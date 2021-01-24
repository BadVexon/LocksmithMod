package theAnime.actions;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.SpawnMonsterAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.beyond.SnakeDagger;
import com.megacrit.cardcrawl.monsters.exordium.*;
import theAnime.monsters.*;

public class SummonDummyAction extends AbstractGameAction {
    private static final float MAX_Y = 250.0F;
    private static final float MIN_Y = 150.0F;
    private static final float MIN_X = -350.0F;
    private static final float MAX_X = 150.0F;
    private DummyTypes myDummy;
    private int hp;
    private int special;
    private AbstractCard possCard;

    public enum DummyTypes {
        BLOCK,
        CRIPPLE,
        EMPTY,
        EXPLODE,
        HEXX,
        SHIELDING,
        STRONG,
        DIO,
        STASIS,
        KEYS,
        VALUE
    }

    public SummonDummyAction(DummyTypes d, int hp, int amount, AbstractCard possCard) {
        myDummy = d;
        this.hp = hp;
        this.special = amount;
        this.actionType = ActionType.SPECIAL;
        this.possCard = possCard;
    }

    public SummonDummyAction(DummyTypes d, int hp, int magic) {
        this(d, hp, magic, null);
    }

    public SummonDummyAction(DummyTypes d, int hp) {
        this(d, hp, -1);
    }

    @Override
    public void update() {
        //first, find a good position

        float x = MathUtils.random(MIN_X, MAX_X);
        float y = MathUtils.random(MIN_Y, MAX_Y);

        AbstractMonster m;
        switch (myDummy) {
            case BLOCK:
                m = new BlockDummy(x, y, hp, special);
                break;
            case CRIPPLE:
                m = new CrippleDummy(x, y, hp, special);
                break;
            case EMPTY:
                m = new EmptyDummy(x, y, hp);
                break;
            case EXPLODE:
                m = new ExplodeDummy(x, y, hp, special);
                break;
            case HEXX:
                m = new HexxDummy(x, y, hp);
                break;
            case SHIELDING:
                m = new ShieldingDummy(x, y, hp);
                break;
            case STRONG:
                m = new StrongDummy(x, y, hp, special);
                break;
            case DIO:
                m = new DioDummy(x, y, hp);
                break;
            case STASIS:
                m = new CardDummy(x, y, hp, possCard);
                break;
            case KEYS:
                m = new KeysDummy(x, y, hp);
                break;
            case VALUE:
                m = new ValueDummy(x, y, hp, special);
                break;
            default:
                m = new EmptyDummy(x, y, hp);
                System.out.println("BAD BUG");
                break;
        }

        x = m.hb_x; //multiplied by scale
        y = m.hb_y;

        float actualX = m.hb.x;
        float actualY = m.hb.y;
        float adjustDistance = 0;
        float adjustAngle = 0;
        float xOffset = 0;
        float yOffset = 0;
        boolean success = false;

        //check if this is a fine position.
        while (!success) {
            success = true;
            for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
                if (!(monster.isDeadOrEscaped() && (!monster.id.equals(GremlinWarrior.ID) && !monster.id.equals(GremlinTsundere.ID) && !monster.id.equals(GremlinThief.ID) && !monster.id.equals(GremlinFat.ID) && !monster.id.equals(GremlinWizard.ID) && !monster.id.equals(SnakeDagger.ID)))) //we don't care about sparks that died, but other enemies could be issues (like repto daggers which have same pos)
                {
                    if (overlap(monster.hb, m.hb)) {
                        success = false;

                        adjustAngle = (adjustAngle + 0.1f) % (MathUtils.PI2);
                        adjustDistance += 10.0f;

                        xOffset = MathUtils.cos(adjustAngle) * adjustDistance;
                        yOffset = MathUtils.sin(adjustAngle) * adjustDistance;

                        m.hb.x = actualX + xOffset;
                        m.hb.y = actualY + yOffset;

                        break;
                    }
                }
            }
        }

        m.hb.move(m.hb.x + m.hb.width / 2.0f, m.hb.y + m.hb.height / 2.0f);
        m.hb_x = m.hb.cX - (m.drawX + m.animX);
        m.hb_y = m.hb.cY - (m.drawY + m.animY);
        m.healthHb.move(m.hb.cX, m.hb.cY - m.hb_h / 2.0F - m.healthHb.height / 2.0F);

        AbstractDungeon.actionManager.addToTop(new AbstractGameAction() {
            @Override
            public void update() {
                isDone = true;
                m.usePreBattleAction();
            }
        });
        AbstractDungeon.actionManager.addToTop(new SpawnMonsterAction(m, true));


        this.isDone = true;
    }

    private static final float BORDER = 20.0F * Settings.scale;

    private static boolean overlap(Hitbox a, Hitbox b) {
        if (a.x > b.x + (b.width + BORDER) || b.x > a.x + (a.width + BORDER))
            return false;

        return !(a.y > b.y + (b.height + BORDER) || b.y > a.y + (a.height + BORDER));
    }
}
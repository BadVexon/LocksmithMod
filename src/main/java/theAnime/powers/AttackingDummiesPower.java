package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.cards.AbstractTodoCard;
import theAnime.monsters.AbstractDummy;
import theAnime.util.TextureLoader;

public class AttackingDummiesPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("AttackingDummiesPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Attacking84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Attacking32.png");

    public AttackingDummiesPower(final int amount) {
        name = "Tsundere Dummies";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onInitialApplication() {
        for (AbstractMonster q : AbstractTodoCard.monsterList()) {
            if (q instanceof AbstractDummy) {
                q.rollMove();
            }
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new AttackingDummiesPower(amount);
    }

    @Override
    public void updateDescription() {
        description = "Dummies attack you for #b" + amount + " damage.";
    }
}
package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;

public class TheLock extends AbstractTodoCard {

    public final static String ID = makeID("TheLock");

    //stupid intellij stuff ATTACK, ENEMY, RARE

    private static final int DAMAGE = 36;
    private static final int UPG_DAMAGE = 8;

    public TheLock() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        lockme(3);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                isDone = true;
                for (AbstractCard q : AbstractDungeon.player.hand.group) {
                    if (!q.hasTag(AnimeMod.KEY))
                        lockme(q, 1, true);
                }
            }
        });
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}
package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;

public class LockSmack extends AbstractTodoCard {

    public final static String ID = makeID("LockSmack");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 11;
    private static final int UPG_DAMAGE = 4;

    public LockSmack() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                isDone = true;
                if (!p.drawPile.isEmpty()) {
                    AbstractCard q = AbstractDungeon.player.drawPile.getTopCard();
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
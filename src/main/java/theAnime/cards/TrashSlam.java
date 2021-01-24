package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class TrashSlam extends AbstractTodoCard {

    public final static String ID = makeID("TrashSlam");

    //stupid intellij stuff ATTACK, ENEMY, UNCOMMON

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 5;

    private static final int MAGIC = 1;

    public TrashSlam() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void calculateCardDamage(AbstractMonster mo) {
        int realBaseDamage = this.baseDamage;// 70
        baseDamage += AbstractDungeon.player.exhaustPile.size() * magicNumber;
        super.calculateCardDamage(mo);// 73
        this.baseDamage = realBaseDamage;// 75
        this.isDamageModified = this.damage != this.baseDamage;// 78
    }// 79

    @Override
    public void applyPowers() {
        int realBaseDamage = this.baseDamage;// 70
        baseDamage += AbstractDungeon.player.exhaustPile.size() * magicNumber;
        super.applyPowers();// 73
        this.baseDamage = realBaseDamage;// 75
        this.isDamageModified = this.damage != this.baseDamage;// 78
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}
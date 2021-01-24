package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.combat.FlyingOrbEffect;

public class PowerSap extends AbstractTodoCard {

    public final static String ID = makeID("PowerSap");

    //stupid intellij stuff ATTACK, ENEMY, UNCOMMON

    private static final int DAMAGE = 9;
    private static final int UPG_DAMAGE = 3;

    public PowerSap() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        lockme();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        if (crippled(m)) {
            atb(new VFXAction(new FlyingOrbEffect(m.hb.cX, m.hb.cY)));
            applyToSelf(new StrengthPower(p, 1));
            applyToEnemy(m, new StrengthPower(m, -1));
        }
    }

    @Override
    public void triggerOnGlowCheck() {
        crippledGlowCheck();
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}
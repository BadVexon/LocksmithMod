package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.HexxPower;

public class Horrify extends AbstractTodoCard {

    public final static String ID = makeID("Horrify");

    //stupid intellij stuff SKILL, ALL_ENEMY, UNCOMMON

    private static final int MAGIC = 6;
    private static final int UPG_MAGIC = 3;

    public Horrify() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractMonster q : monsterList()) {
            if (crippled(q)) {
                applyToEnemy(q, new HexxPower(q, magicNumber));
            }
        }
        for (AbstractMonster q : monsterList()) {
            equalize(q);
        }
    }

    @Override
    public void triggerOnGlowCheck() {
        crippledGlowCheck();
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}
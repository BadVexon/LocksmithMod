package theAnime.monsters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.CripplingPower;

public class CrippleDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("CrippleDummy");
    private int amount;

    public CrippleDummy(float x, float y, int hp, int special) {
        super(ID, x, y, hp);
        this.amount = special;
        myColor = Color.GREEN.cpy();
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new CripplingPower(this, amount));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new CrippleDummy(x2, y2, basehp, amount);
    }
}

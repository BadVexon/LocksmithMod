package theAnime.monsters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.StrongingPower;

public class StrongDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("StrongDummy");
    private int amount;

    public StrongDummy(float x, float y, int hp, int amount) {
        super(ID, x, y, hp);
        this.amount = amount;
        myColor = Color.ORANGE.cpy();
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new StrongingPower(this, amount));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new StrongDummy(x2, y2, basehp, amount);
    }
}

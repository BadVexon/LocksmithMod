package theAnime.monsters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.ValuePower;

public class ValueDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("ValueDummy");
    private int amount;

    public ValueDummy(float x, float y, int hp, int special) {
        super(ID, x, y, hp);
        this.amount = special;
        myColor = Color.GOLD.cpy();
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new ValuePower(this, amount));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new ValueDummy(x2, y2, basehp, amount);
    }
}

package theAnime.monsters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.BlockingDeathPower;

public class BlockDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("BlockDummy");

    public int amount;

    public BlockDummy(float x, float y, int hp, int amount) {
        super(ID, x, y, hp);
        this.amount = amount;
        myColor = Color.BLUE.cpy();
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new BlockingDeathPower(this, amount));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new BlockDummy(x2, y2, basehp, amount);
    }
}

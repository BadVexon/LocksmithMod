package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.monsters.AbstractDummy;
import theAnime.util.TextureLoader;

public class TsunderePower extends AbstractPower implements CloneablePowerInterface, OnMonsterDeathPower {
    public static final String POWER_ID = AnimeMod.makeID("TsunderePower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Tsun84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Tsun32.png");

    public TsunderePower(final int amount) {
        name = "B-Baka!";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onMonsterDeath(AbstractMonster monster) {
        if (monster instanceof AbstractDummy) {
            flash();
            addToBot(new GainBlockAction(owner, amount));
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new TsunderePower(amount);
    }

    @Override
    public void updateDescription() {
        description = "Whenever a Dummy dies, gain #b" + amount + " #yBlock.";
    }
}
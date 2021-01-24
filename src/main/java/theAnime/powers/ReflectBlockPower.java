package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class ReflectBlockPower extends AbstractPower implements CloneablePowerInterface, OnLoseHpMonsterPower {
    public static final String POWER_ID = AnimeMod.makeID("ReflectBlockPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Mirror84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Mirror32.png");

    public ReflectBlockPower(AbstractCreature owner) {
        name = "Mirror Shield";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = -1;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onLoseHpMonster(int damageAmount) {
        if (damageAmount > 0) {
            flash();
            addToBot(new GainBlockAction(AbstractDungeon.player, damageAmount));
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new ReflectBlockPower(owner);
    }

    @Override
    public void updateDescription() {
        description = "Whenever " + owner.name + " loses HP, you gain that much #yBlock.";
    }
}
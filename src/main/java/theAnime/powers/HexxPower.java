package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.PoisonLoseHpAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class HexxPower extends AbstractPower implements CloneablePowerInterface, HealthBarRenderPower {
    public static final String POWER_ID = AnimeMod.makeID("HexxPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Pestered_84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Pestered_32.png");
    private static final Color barColor = Color.valueOf("a47da4");

    public HexxPower(AbstractCreature owner, int amount) {
        name = "Hexxed";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;

        type = PowerType.DEBUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void atStartOfTurn() {
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
                flashWithoutSound();
                AbstractDungeon.actionManager.addToBottom(new PoisonLoseHpAction(owner, AbstractDungeon.player, amount, AbstractGameAction.AttackEffect.POISON));
            }
        }
    }

    @Override
    public void onSpecificTrigger() {
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
                flashWithoutSound();
                AbstractDungeon.actionManager.addToBottom(new PoisonLoseHpAction(owner, AbstractDungeon.player, amount, AbstractGameAction.AttackEffect.POISON));
            }
        }
    }

    @Override
    public int getHealthBarAmount() {
        if (owner.hasPower(SoulSuckerPower.POWER_ID)) {
            int x = 1;
            x += owner.getPower(SoulSuckerPower.POWER_ID).amount;
            return amount * x;
        }
        return amount;
    }

    @Override
    public Color getColor() {
        return barColor;
    }

    @Override
    public AbstractPower makeCopy() {
        return new HexxPower(owner, amount);
    }

    @Override
    public void updateDescription() {
        description = "At the start of its turn, loses #b" + amount + " HP.";
    }
}
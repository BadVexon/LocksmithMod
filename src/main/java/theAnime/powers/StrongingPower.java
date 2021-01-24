package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import basemod.patches.whatmod.WhatMod;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class StrongingPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("StrongingPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Store84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Store32.png");

    public StrongingPower(AbstractCreature owner, int amount) {
        name = "Stored Strength";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onDeath() {
        flash();
        addToBot(new ApplyPowerAction(AbstractDungeon.player, owner, new StrengthPower(AbstractDungeon.player, amount)));
    }

    @Override
    public AbstractPower makeCopy() {
        return new StrongingPower(owner, amount);
    }

    @Override
    public void updateDescription() {
        description = "When " + owner.name + " dies, you gain #b" + amount + " #yStrength.";
    }
}
package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theAnime.AnimeMod;
import theAnime.cards.AbstractTodoCard;
import theAnime.cards.Key;
import theAnime.util.TextureLoader;

public class DrainingMiasmaPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("DrainingMiasmaPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Draining84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Draining32.png");

    public DrainingMiasmaPower(final int amount) {
        name = "Draining Miasma";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        isTurnBased = true;
        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onExhaust(AbstractCard card) {
        flash();
        for (AbstractMonster q : AbstractTodoCard.monsterList()) {
            AbstractDungeon.actionManager.addToBottom(new LoseHPAction(q, owner, amount));
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new DrainingMiasmaPower(amount);
    }

    @Override
    public void updateDescription() {
        description = "Whenever a card is #yExhausted, ALL enemies lose #b" + amount + " HP.";
    }
}
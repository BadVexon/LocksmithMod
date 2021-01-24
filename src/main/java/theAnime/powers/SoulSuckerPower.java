package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.actions.TriggerPowerAction;
import theAnime.cards.AbstractTodoCard;
import theAnime.util.TextureLoader;

public class SoulSuckerPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("SoulSuckerPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Drain84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Drain32.png");

    public SoulSuckerPower(final int amount) {
        name = "Soul Sucker";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        flash();
        for (AbstractMonster q : AbstractTodoCard.monsterList()) {
            if (q.hasPower(HexxPower.POWER_ID) && AbstractTodoCard.crippled(q)) {
                for (int i = 0; i < this.amount; ++i)
                    AbstractDungeon.actionManager.addToBottom(new TriggerPowerAction(q, HexxPower.POWER_ID));
            }
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new SoulSuckerPower(amount);
    }

    @Override
    public void updateDescription() {
        if (amount == 1)
            description = "At the end of your turn, trigger the #yHexx of #yCrippled enemies.";
        else
            description = "At the end of your turn, trigger the #yHexx of #yCrippled enemies #b" + amount + " times.";
    }
}

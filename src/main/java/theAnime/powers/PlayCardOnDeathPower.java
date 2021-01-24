package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class PlayCardOnDeathPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("PlayCardOnDeathPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Card84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Card32.png");
    private AbstractCard card;

    public PlayCardOnDeathPower(AbstractCreature owner, AbstractCard card) {
        name = "Harvesting";
        ID = POWER_ID;

        this.owner = owner;
        this.card = card;
        this.amount = -1;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public AbstractPower makeCopy() {
        return new PlayCardOnDeathPower(owner, card);
    }

    @Override
    public void onDeath() {
        flash();
        addToBot(new NewQueueCardAction(card, true, false, true));
    }

    @Override
    public void updateDescription() {
        description = "When " + owner.name + " dies, play " + card.name + ".";
    }
}
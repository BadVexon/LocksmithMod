package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.actions.DamageAllNonDummyEnemiesAction;
import theAnime.util.TextureLoader;

public class ExplodingPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("ExplodingPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Exploding84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Exploding32.png");

    public ExplodingPower(AbstractCreature owner, int amount) {
        name = "KAPOWIE";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public AbstractPower makeCopy() {
        return new ExplodingPower(owner, amount);
    }

    @Override
    public void onDeath() {
        flash();
        addToBot(new DamageAllNonDummyEnemiesAction(owner, DamageInfo.createDamageMatrix(amount, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
    }

    @Override
    public void updateDescription() {
        description = "When " + owner.name + " dies, it deals #b" + amount + " damage to ALL non-Dummy enemies.";
    }
}
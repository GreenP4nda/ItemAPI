package at.green_panda.utilities.itemapi;

import com.google.common.collect.Multimap;
import com.sun.istack.internal.NotNull;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.BlockState;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.data.BlockData;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Axolotl.Variant;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.meta.BookMeta.Generation;
import org.bukkit.map.MapView;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

/**
 * Created by Green_Panda
 * "Simplifies the creation and usage of the Spigot ItemStack."
 *
 * Terms Of Use:
 *  - This API is aimed for a non profit market only, which means any form of monetization is prohibited.
 *    If you want to use this API for commercial use, please ask first get my permission. For this just message me via Discord: "Green_Panda#5620"
 *  - You also mustn't claim it as your own work or change the author.
 *    This should be obvious since this API wasn't really challenging but quite tedious work.
 *    Also this includes classes that are based off of this code. If you want to adapt this API must include a credit to the original author.
 *
 * Feedback:
 *  - If you want to give feedback or add a special function to this API for everyone to use, then please leave a comment or contact me via Discord: "Green_Panda#5620".
 *
 *  Support:
 *  - If you need support, please contract me via Discord: "Green_Panda#5620".
 */

public class ItemManager {
    public ItemStack itemStack;
    public ItemMeta  itemMeta;

    public ItemManager(Material type) {
        new ItemManager(type, 1, (short) 0, null);
    }
    public ItemManager(Material type, Byte data) {
        new ItemManager(type, 1, (short) 0, data);
    }
    public ItemManager(Material type, int amount) {
        new ItemManager(type, amount, (short) 0, null);
    }
    public ItemManager(Material type, int amount, Byte data) {
        new ItemManager(type, amount, (short) 0, data);
    }
    public ItemManager(Material type, int amount, short damage) {
        new ItemManager(type, amount, damage, null);
    }
    public ItemManager(Material type, int amount, short damage, Byte data) {
        this.itemStack = new ItemStack(type, amount, damage, data);
        this.itemMeta  = this.itemStack.getItemMeta();
    }
    public ItemManager(ItemStack item) {
        this.itemStack = item;
        this.itemMeta  = item.getItemMeta();
    }

    public static ItemManager from(Material type) {
        return new ItemManager(type, 1, (short) 0, null);
    }
    public static ItemManager from(Material type, Byte data) {
        return new ItemManager(type, 1, (short) 0, data);
    }
    public static ItemManager from(Material type, int amount) {
        return new ItemManager(type, amount, (short) 0, null);
    }
    public static ItemManager from(Material type, int amount, Byte data) {
        return  new ItemManager(type, amount, (short) 0, data);
    }
    public static ItemManager from(Material type, int amount, short damage) {
        return  new ItemManager(type, amount, damage, null);
    }
    public static ItemManager from(Material type, int amount, short damage, Byte data) {
        return new ItemManager(type, amount, damage, data);
    }
    public static ItemManager from(ItemStack item) {
        return new ItemManager(item);
    }

    // ---------------------------------------- [          Default          ] ---------------------------------------- \\
    /***
     * Add an Attribute and it's Modifier.
     * @param attribute specify the attribute to modify
     * @param modifier specify the modifier
     */
    public ItemManager addAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        this.itemMeta.addAttributeModifier(attribute, modifier);
        return this;
    }

    /***
     * Adds the specified enchantment to this item meta.
     * @param enchantment specify the enchantment
     * @param level specify the level
     * @param ignoreLevelRestriction specify whether the enchantment level restriction should be ignored
     */
    public ItemManager addEnchant(Enchantment enchantment, int level, boolean ignoreLevelRestriction) {
        this.itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction);
        return this;
    }

    /***
     * Set item flags which should be ignored when rendering a ItemStack in the Client.
     * @param itemFlags specify the item flags
     */
    public ItemManager addItemFlag(ItemFlag... itemFlags) {
        this.itemMeta.addItemFlags(itemFlags);
        return this;
    }

    /***
     * Return an immutable copy of all Attributes and their modifiers in this ItemMeta.
     * Returns null if none exist.
     */
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers() {
        return this.itemMeta.getAttributeModifiers();
    }

    /***
     * Return an immutable copy of all AttributeModifiers for a given Attribute
     * @param attribute specify the desired attribute
     */
    public Collection<AttributeModifier> getAttributeModifiers(Attribute attribute) {
        return this.itemMeta.getAttributeModifiers(attribute);
    }

    /***
     * Return an immutable copy of all Attributes and their AttributeModifiers for a given EquipmentSlot.
     * Any AttributeModifier that does have have a given EquipmentSlot will be returned.
     * @param slot specify the target slot
     */
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return this.itemMeta.getAttributeModifiers(slot);
    }

    /***
     * Gets the custom model data that is set.
     */
    public int getCustomModelData() {
        return this.itemMeta.getCustomModelData();
    }

    /***
     * Gets the display name that is set.
     */
    public String getDisplayName() {
        return this.itemMeta.getDisplayName();
    }

    /***
     * Checks for the level of the specified enchantment.
     * @param ench specify the desired enchantment
     */
    public int getEnchantLevel(Enchantment ench) {
        return this.itemMeta.getEnchantLevel(ench);
    }

    /***
     * Returns a copy the enchantments in this ItemMeta.
     */
    public Map<Enchantment, Integer> getEnchants() {
        return this.itemMeta.getEnchants();
    }

    /***
     * Get current set itemFlags.
     */
    public Set<ItemFlag> getItemFlags() {
        return this.itemMeta.getItemFlags();
    }

    /***
     * Gets the localized display name that is set.
     */
    public String getLocalizedName() {
        return this.itemMeta.getLocalizedName();
    }

    /***
     * Gets the lore that is set.
     */
    public List<String> getLore() {
        return this.itemMeta.getLore();
    }

    /***
     * Checks for the existence of any AttributeModifiers.
     */
    public boolean hasAttributeModifiers() {
        return this.itemMeta.hasAttributeModifiers();
    }

    /***
     * Checks if the specified enchantment conflicts with any enchantments in this ItemMeta.
     * @param ench specify the desired enchantment
     */
    public boolean hasConflictingEnchant(Enchantment ench) {
        return this.itemMeta.hasConflictingEnchant(ench);
    }

    /***
     * Checks for existence of custom model data.
     */
    public boolean hasCustomModelData() {
        return this.itemMeta.hasCustomModelData();
    }

    /***
     * Checks for existence of a display name.
     */
    public boolean hasDisplayName() {
        return this.itemMeta.hasDisplayName();
    }

    /***
     * Checks for existence of the specified enchantment.
     * @param ench specify the desired enchantment
     */
    public boolean hasEnchant(Enchantment ench) {
        return this.itemMeta.hasEnchant(ench);
    }

    /***
     * Checks for the existence of any enchantments.
     */
    public boolean hasEnchants() {
        return this.itemMeta.hasEnchants();
    }

    /***
     * Check if the specified flag is present on this item.
     * @param flag specify the desired flag
     */
    public boolean hasItemFlag(ItemFlag flag) {
        return this.itemMeta.hasItemFlag(flag);
    }

    /***
     * Checks for existence of a localized name.
     */
    public boolean hasLocalizedName() {
        return this.itemMeta.hasLocalizedName();
    }

    /***
     * Checks for existence of lore.
     */
    public boolean hasLore() {
        return this.itemMeta.hasLore();
    }

    /***
     * Return if the unbreakable tag is true.
     */
    public boolean isUnbreakable() {
        return this.itemMeta.isUnbreakable();
    }

    /***
     * Remove all AttributeModifiers associated with the given Attribute.
     * @param attribute specify the desired attribute
     */
    public ItemManager removeAttributeModifier(Attribute attribute) {
        this.itemMeta.removeAttributeModifier(attribute);
        return this;
    }

    /***
     * Remove a specific Attribute and AttributeModifier.
     * @param attribute specify the desired attribute
     * @param modifier specify the desired modifier
     */
    public ItemManager removeAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        this.itemMeta.removeAttributeModifier(attribute, modifier);
        return this;
    }

    /***
     * Remove all Attributes and AttributeModifiers for a given EquipmentSlot.
     * If the given EquipmentSlot is null, this will remove all AttributeModifiers that do not have an EquipmentSlot set.
     * @param slot specify the desired slot
     */
    public ItemManager removeAttributeModifier(EquipmentSlot slot) {
        this.itemMeta.removeAttributeModifier(slot);
        return this;
    }

    /***
     * Removes the specified enchantment from this item meta.
     * @param ench specify the desired enchantment
     */
    public ItemManager removeEnchant(Enchantment ench) {
        this.itemMeta.removeEnchant(ench);
        return this;
    }

    /***
     * Remove specific set of itemFlags.
     * @param itemFlags specify the desired item flag(s)
     */
    public ItemManager removeItemFlags(ItemFlag... itemFlags) {
        this.itemMeta.removeItemFlags(itemFlags);
        return this;
    }

    /***
     * Set all Attributes and their AttributeModifiers.
     * @param attributeModifiers specify the desired attribute modifiers
     */
    public ItemManager setAttributeModifiers(Multimap<Attribute,AttributeModifier> attributeModifiers) {
        this.itemMeta.setAttributeModifiers(attributeModifiers);
        return this;
    }

    /***
     * Sets the custom model data.
     * @param data specify the desired custom model data
     */
    public ItemManager setCustomModelData(Integer data) {
        this.itemMeta.setCustomModelData(data);
        return this;
    }

    /***
     * Sets the display name.
     * @param name specify the desired display name
     */
    public ItemManager setDisplayName(String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    /***
     * Sets the localized name.
     * @param name specify the desired localized name
     */
    public ItemManager setLocalizedName(String name) {
        this.itemMeta.setLocalizedName(name);
        return this;
    }

    /***
     * Sets the lore for this item.
     * @param lore specify the desired lore lines
     */
    public ItemManager setLore(List<String> lore) {
        this.itemMeta.setLore(lore);
        return this;
    }

    /***
     * Adds lines to the end of the lore.
     * @param lines specify the desired lore line(s) to add
     */
    public ItemManager addLoreLines(String...lines) {
        Objects.requireNonNull(this.itemMeta.getLore()).addAll(Arrays.asList(lines));
        return this;
    }

    /***
     * Remove lines by their index.
     * @param lines specify the desired lore indices to remove
     */
    public ItemManager removeLoreLines(int...lines) {
        for (int line : lines) Objects.requireNonNull(this.itemMeta.getLore()).remove(line);
        return this;
    }

    /***
     * Sets the unbreakable tag.
     * @param unbreakable specify if the item should be unbreakable
     */
    public ItemManager setUnbreakable(boolean unbreakable) {
        this.itemMeta.setUnbreakable(unbreakable);
        return this;
    }

    // ---------------------------------------- [    Axolotl Bucket Meta    ] ---------------------------------------- \\
    /***
     * Set the variant of this axolotl in the bucket. | Requires: Axolotl Meta!
     * @param variant specify the axolotl variant
     */
    public ItemManager setAxolotlVariant(Variant variant) {
        if(!(this.itemMeta instanceof AxolotlBucketMeta)) try { throw new IncompatibleMetaException(AxolotlBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((AxolotlBucketMeta)this.itemMeta).setVariant(variant);
        return this;
    }

    /***
     * Checks for existence of a variant tag indicating a specific axolotl will be spawned. | Requires: Axolotl Meta!
     */
    public boolean hasAxolotlVariant() {
        if(!(this.itemMeta instanceof AxolotlBucketMeta)) try { throw new IncompatibleMetaException(AxolotlBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((AxolotlBucketMeta)this.itemMeta).hasVariant();
    }

    /***
     * Get the variant of the axolotl in the bucket. | Requires: Axolotl Meta!
     */
    public Variant getAxolotlVariant() {
        if(!(this.itemMeta instanceof AxolotlBucketMeta)) try { throw new IncompatibleMetaException(AxolotlBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((AxolotlBucketMeta)this.itemMeta).getVariant();
    }

    // ---------------------------------------- [        Banner Meta        ] ---------------------------------------- \\
    /***
     * Adds a new pattern on top of the existing patterns. | Requires: Banner Meta!
     * @param pattern specify the pattern
     */
    public ItemManager addBannerPattern(Pattern pattern) {
        if(!(this.itemMeta instanceof BannerMeta)) try { throw new IncompatibleMetaException(BannerMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BannerMeta)this.itemMeta).addPattern(pattern);
        return this;
    }

    /***
     * Returns the base color of this banner. | Requires: Banner Meta!
     */
    public DyeColor getBannerBaseColor() {
        if(!(this.itemMeta instanceof BannerMeta)) try { throw new IncompatibleMetaException(BannerMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return DyeColor.getByDyeData(itemStack.getData().getData());
    }

    /***
     * Returns the pattern at a specified index. | Requires: Banner Meta!
     * @param i specify the pattern index
     */
    public Pattern getBannerPattern(int i) {
        if(!(this.itemMeta instanceof BannerMeta)) try { throw new IncompatibleMetaException(BannerMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BannerMeta)this.itemMeta).getPattern(i);
    }

    /***
     * Returns a list of patterns on this banner. | Requires: Banner Meta!
     */
    public List<Pattern> getBannerPatterns() {
        if(!(this.itemMeta instanceof BannerMeta)) try { throw new IncompatibleMetaException(BannerMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BannerMeta)this.itemMeta).getPatterns();
    }

    /***
     * Returns the number of patterns on this banner. | Requires: Banner Meta!
     */
    public int getNumberOfBannerPatterns() {
        if(!(this.itemMeta instanceof BannerMeta)) try { throw new IncompatibleMetaException(BannerMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BannerMeta)this.itemMeta).numberOfPatterns();
    }

    /***
     * Removes the pattern at the specified index. | Requires: Banner Meta!
     * @param i specify the pattern index
     */
    public ItemManager removeBannerPattern(int i) {
        if(!(this.itemMeta instanceof BannerMeta)) try { throw new IncompatibleMetaException(BannerMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BannerMeta)this.itemMeta).removePattern(i);
        return this;
    }

    /***
     * Sets the base color of this banner. | Requires: Banner Meta!
     * @param dyeColor specify the dye color
     */
    public ItemManager setBannerBaseColor(DyeColor dyeColor) {
        if(!(this.itemMeta instanceof BannerMeta)) try { throw new IncompatibleMetaException(BannerMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        itemStack.getData().setData(dyeColor.getDyeData());
        return this;
    }

    /***
     * Sets the pattern at the specified index. | Requires: Banner Meta!
     * @param i specify the pattern Index
     * @param pattern specify the pattern
     */
    public ItemManager setPattern(int i, Pattern pattern) {
        if(!(this.itemMeta instanceof BannerMeta)) try { throw new IncompatibleMetaException(BannerMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BannerMeta)this.itemMeta).setPattern(i, pattern);
        return this;
    }

    /***
     * Sets the patterns used on this banner. | Requires: Banner Meta!
     * @param patterns specify the patterns
     */
    public ItemManager setPatterns(Pattern...patterns) {
        if(!(this.itemMeta instanceof BannerMeta)) try { throw new IncompatibleMetaException(BannerMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BannerMeta)this.itemMeta).setPatterns(Arrays.asList(patterns));
        return this;
    }

    // ---------------------------------------- [      Block Data Meta      ] ---------------------------------------- \\
    /***
     * Returns the currently attached block data from this item or creates a new one if one doesn't exist. | Requires: Block Data Meta!
     * @param material specify the material
     */
    public BlockData getBlockData(Material material) {
        if(!(this.itemMeta instanceof BlockDataMeta)) try { throw new IncompatibleMetaException(BlockDataMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BlockDataMeta)this.itemMeta).getBlockData(material);
    }

    /***
     * Returns whether the item has block data currently attached to it. | Requires: Block Data Meta!
     */
    public boolean hasBlockData() {
        if(!(this.itemMeta instanceof BlockDataMeta)) try { throw new IncompatibleMetaException(BlockDataMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BlockDataMeta)this.itemMeta).hasBlockData();
    }

    /***
     * Attaches a copy of the passed block data to the item. | Requires: Block Data Meta!
     * @param blockData specify the block data
     */
    public ItemManager setBlockData(BlockData blockData) {
        if(!(this.itemMeta instanceof BlockDataMeta)) try { throw new IncompatibleMetaException(BlockDataMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BlockDataMeta)this.itemMeta).setBlockData(blockData);
        return this;
    }

    // ---------------------------------------- [      Block State Meta     ] ---------------------------------------- \\
    /***
     * Returns the currently attached block state for this item or creates a new one if one doesn't exist. | Requires: Block State Meta!
     */
    public BlockState getBlockState() {
        if(!(this.itemMeta instanceof BlockStateMeta)) try { throw new IncompatibleMetaException(BlockStateMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BlockStateMeta)this.itemMeta).getBlockState();
    }

    /***
     * Returns whether the item has a block state currently attached to it. | Requires: Block State Meta!
     */
    public boolean hasBlockState() {
        if(!(this.itemMeta instanceof BlockStateMeta)) try { throw new IncompatibleMetaException(BlockStateMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BlockStateMeta)this.itemMeta).hasBlockState();
    }

    /***
     * Attaches a copy of the passed block state to the item. | Requires: Block State Meta!
     * @param blockState specify the block state
     */
    public ItemManager setBlockState(BlockState blockState) {
        if(!(this.itemMeta instanceof BlockStateMeta)) try { throw new IncompatibleMetaException(BlockStateMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BlockStateMeta)this.itemMeta).setBlockState(blockState);
        return this;
    }

    // ---------------------------------------- [         Book Meta         ] ---------------------------------------- \\
    /***
     * Adds new pages to the end of the book. | Requires: Book Meta!
     * @param pages specify the content of the pages
     */
    public ItemManager addBookPage(String...pages) {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BookMeta)this.itemMeta).addPage(pages);
        return this;
    }

    /***
     * Gets the author of the book. | Requires: Book Meta!
     */
    public String getBookAuthor() {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).getAuthor();
    }

    /***
     * Gets the generation of the book. | Requires: Book Meta!
     */
    public Generation getBookGeneration() {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).getGeneration();
    }

    /***
     * Gets the specified page in the book. | Requires: Book Meta!
     * @param i specify the page index
     */
    public String getBookPage(int i) {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).getPage(i);
    }

    /***
     * Gets the number of pages in the book. | Requires: Book Meta!
     */
    public int getBookPageCount() {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).getPageCount();
    }

    /***
     * Gets all the pages in the book. | Requires: Book Meta!
     */
    public List<String> getBookPages() {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).getPages();
    }

    /***
     * Gets the title of the book. | Requires: Book Meta!
     */
    public String getBookTitle() {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).getTitle();
    }

    /***
     * Checks for the existence of an author in the book. | Requires: Book Meta!
     */
    public boolean hasBookAuthor() {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).hasAuthor();
    }

    /***
     * Checks for the existence of generation level in the book. | Requires: Book Meta!
     */
    public boolean hasBookGeneration() {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).hasGeneration();
    }

    /***
     * Checks for the existence of pages in the book. | Requires: Book Meta!
     */
    public boolean hasBookPages() {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).hasPages();
    }

    /***
     * Checks for the existence of a title in the book. | Requires: Book Meta!
     */
    public boolean hasBookTitle() {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BookMeta)this.itemMeta).hasTitle();
    }

    /***
     * Sets the author of the book. | Requires: Book Meta!
     * @param author specify the author
     */
    public ItemManager setBookAuthor(String author) {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BookMeta)this.itemMeta).setAuthor(author);
        return this;
    }

    /***
     * Sets the generation of the book. | Requires: Book Meta!
     * @param gen specify the generation
     */
    public ItemManager setBookGeneration(Generation gen) {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BookMeta)this.itemMeta).setGeneration(gen);
        return this;
    }

    /***
     * Sets the specified page in the book. | Requires: Book Meta!
     * @param i specify the page index
     * @param page specify the content of the page
     */
    public ItemManager setBookPage(int i,  String page) {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BookMeta)this.itemMeta).setPage(i, page);
        return this;
    }

    /***
     * Clears the existing book pages and sets the book to use the provided pages. | Requires: Book Meta!
     * @param pages specify the content of the pages
     */
    public ItemManager setBookPages(String...pages) {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BookMeta)this.itemMeta).setPages(pages);
        return this;
    }

    /***
     * Sets the title of the book. | Requires: Book Meta!
     * @param title specify the title
     */
    public ItemManager setBookTitle(String title) {
        if(!(this.itemMeta instanceof BookMeta)) try { throw new IncompatibleMetaException(BookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BookMeta)this.itemMeta).setTitle(title);
        return this;
    }

    // ---------------------------------------- [        Bundle Meta        ] ---------------------------------------- \\
    /***
     * Adds an item to this item. | Requires: Bundle Meta!
     * @param item specify the item to add
     */
    public ItemManager addBundleItem(ItemStack item) {
        if(!(this.itemMeta instanceof BundleMeta)) try { throw new IncompatibleMetaException(BundleMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BundleMeta)this.itemMeta).addItem(itemStack);
        return this;
    }

    /***
     * Returns an immutable list of the items stored in this item. | Requires: Bundle Meta!
     * @param item specify the item to add
     */
    public ItemManager getBundleItems(ItemStack item) {
        if(!(this.itemMeta instanceof BundleMeta)) try { throw new IncompatibleMetaException(BundleMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BundleMeta)this.itemMeta).addItem(itemStack);
        return this;
    }

    /***
     * Returns whether the item has any items. | Requires: Bundle Meta!
     */
    public boolean hasBundleItems() {
        if(!(this.itemMeta instanceof BundleMeta)) try { throw new IncompatibleMetaException(BundleMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((BundleMeta)this.itemMeta).hasItems();
    }

    /***
     * Sets the items stored in this item. | Requires: Bundle Meta!
     */
    public ItemManager setItems(ItemStack...items) {
        if(!(this.itemMeta instanceof BundleMeta)) try { throw new IncompatibleMetaException(BundleMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((BundleMeta)this.itemMeta).setItems(Arrays.asList(items));
        return this;
    }

    // ---------------------------------------- [        Compass Meta       ] ---------------------------------------- \\
    /***
     * Gets the location that this compass will point to. | Requires: Compass Meta!
     */
    public Location getLodestone() {
        if(!(this.itemMeta instanceof CompassMeta)) try { throw new IncompatibleMetaException(CompassMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((CompassMeta)this.itemMeta).getLodestone();
    }

    /***
     * Checks if this compass has been paired to a lodestone. | Requires: Compass Meta!
     */
    public boolean hasLodestone() {
        if(!(this.itemMeta instanceof CompassMeta)) try { throw new IncompatibleMetaException(CompassMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((CompassMeta)this.itemMeta).hasLodestone();
    }

    /***
     * Gets if this compass is tracking a specific lodestone. | Requires: Compass Meta!
     */
    public boolean isLodestoneTracked() {
        if(!(this.itemMeta instanceof CompassMeta)) try { throw new IncompatibleMetaException(CompassMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((CompassMeta)this.itemMeta).isLodestoneTracked();
    }

    /***
     * Gets if this compass is tracking a specific lodestone. | Requires: Compass Meta!
     * @param lodestone specify the lodestone location
     */
    public ItemManager setCompassLodestone(Location lodestone) {
        if(!(this.itemMeta instanceof CompassMeta)) try { throw new IncompatibleMetaException(CompassMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((CompassMeta)this.itemMeta).setLodestone(lodestone);
        return this;
    }

    /***
     * Gets if this compass is tracking a specific lodestone. | Requires: Compass Meta!
     * @param tracked specify if the compass should track a lodestone
     */
    public ItemManager setCompassLodestoneTracked(boolean tracked) {
        if(!(this.itemMeta instanceof CompassMeta)) try { throw new IncompatibleMetaException(CompassMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((CompassMeta)this.itemMeta).setLodestoneTracked(tracked);
        return this;
    }

    // ---------------------------------------- [       Crossbow Meta       ] ---------------------------------------- \\
    /***
     * Adds a charged projectile to this item. | Requires: Crossbow Meta!
     * @param item specify the item to set
     */
    public ItemManager addChargedCrossbowProjectile(ItemStack item) {
        if(!(this.itemMeta instanceof CrossbowMeta)) try { throw new IncompatibleMetaException(CrossbowMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((CrossbowMeta)this.itemMeta).addChargedProjectile(item);
        return this;
    }

    /***
     * Returns an immutable list of the projectiles charged on this item. | Requires: Crossbow Meta!
     */
    public List<ItemStack> getChargedCrossbowProjectiles() {
        if(!(this.itemMeta instanceof CrossbowMeta)) try { throw new IncompatibleMetaException(CrossbowMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((CrossbowMeta)this.itemMeta).getChargedProjectiles();
    }

    /***
     * Returns whether the item has any charged projectiles. | Requires: Crossbow Meta!
     */
    public boolean hasChargedCrossbowProjectiles() {
        if(!(this.itemMeta instanceof CrossbowMeta)) try { throw new IncompatibleMetaException(CrossbowMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((CrossbowMeta)this.itemMeta).hasChargedProjectiles();
    }

    /***
     * Sets the projectiles charged on this item. | Requires: Crossbow Meta!
     * @param items specify the items to set
     */
    public ItemManager setChargedCrossbowProjectiles(ItemStack...items) {
        if(!(this.itemMeta instanceof CrossbowMeta)) try { throw new IncompatibleMetaException(CrossbowMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((CrossbowMeta)this.itemMeta).setChargedProjectiles(Arrays.asList(items));
        return this;
    }


    // ---------------------------------------- [  Enchantment Storage Meta ] ---------------------------------------- \\
    /***
     * Stores the specified enchantment in this item meta. | Requires: Enchantment Storage Meta!
     * @param enchantment specify the enchantment
     * @param level specify the enchantments level
     * @param ignoreLevelRestrictions specify whether the level restriction should be ignored
     */
    public ItemManager addStoredEnchant(Enchantment enchantment, int level, boolean ignoreLevelRestrictions) {
        if(!(this.itemMeta instanceof EnchantmentStorageMeta)) try { throw new IncompatibleMetaException(EnchantmentStorageMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((EnchantmentStorageMeta)this.itemMeta).addStoredEnchant(enchantment, level, ignoreLevelRestrictions);
        return this;
    }

    /***
     * Checks for the level of the stored enchantment. | Requires: Enchantment Storage Meta!
     * @param enchantment specify the desired enchantment
     */
    public int getStoredEnchantLevel(Enchantment enchantment) {
        if(!(this.itemMeta instanceof EnchantmentStorageMeta)) try { throw new IncompatibleMetaException(EnchantmentStorageMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((EnchantmentStorageMeta)this.itemMeta).getStoredEnchantLevel(enchantment);
    }

    /***
     * Gets a copy of the stored enchantments on this item. | Requires: Enchantment Storage Meta!
     */
    public Map<Enchantment, Integer> getStoredEnchants() {
        if(!(this.itemMeta instanceof EnchantmentStorageMeta)) try { throw new IncompatibleMetaException(EnchantmentStorageMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((EnchantmentStorageMeta)this.itemMeta).getStoredEnchants();
    }

    /***
     * Checks if the specified enchantment conflicts with any enchantments on this item. | Requires: Enchantment Storage Meta!
     * @param enchantment specify the enchantment to check
     */
    public boolean hasConflictingStoredEnchant(Enchantment enchantment) {
        if(!(this.itemMeta instanceof EnchantmentStorageMeta)) try { throw new IncompatibleMetaException(EnchantmentStorageMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((EnchantmentStorageMeta)this.itemMeta).hasConflictingStoredEnchant(enchantment);
    }

    /***
     * Checks for storage of the specified enchantment. | Requires: Enchantment Storage Meta!
     * @param enchantment specify the enchantment to check
     */
    public boolean hasStoredEnchant(Enchantment enchantment) {
        if(!(this.itemMeta instanceof EnchantmentStorageMeta)) try { throw new IncompatibleMetaException(EnchantmentStorageMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((EnchantmentStorageMeta)this.itemMeta).hasStoredEnchant(enchantment);
    }

    /***
     * Checks for the existence of any stored enchantments. | Requires: Enchantment Storage Meta!
     */
    public boolean hasStoredEnchants() {
        if(!(this.itemMeta instanceof EnchantmentStorageMeta)) try { throw new IncompatibleMetaException(EnchantmentStorageMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((EnchantmentStorageMeta)this.itemMeta).hasStoredEnchants();
    }

    /***
     * Remove the specified stored enchantment from this item. | Requires: Enchantment Storage Meta!
     */
    public ItemManager removeStoredEnchant(Enchantment enchantment) {
        if(!(this.itemMeta instanceof EnchantmentStorageMeta)) try { throw new IncompatibleMetaException(EnchantmentStorageMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((EnchantmentStorageMeta)this.itemMeta).removeStoredEnchant(enchantment);
        return this;
    }

    // ---------------------------------------- [    Firework Effect Meta   ] ---------------------------------------- \\
    /***
     * Gets the firework effect from this meta. | Requires: Firework Effect Meta!
     */
    public FireworkEffect getFireworkEffect() {
        if(!(this.itemMeta instanceof FireworkEffectMeta)) try { throw new IncompatibleMetaException(FireworkEffectMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((FireworkEffectMeta)this.itemMeta).getEffect();
    }

    /***
     * Checks if this item has an effect. | Requires: Firework Effect Meta!
     */
    public boolean hasFireworkEffect() {
        if(!(this.itemMeta instanceof FireworkEffectMeta)) try { throw new IncompatibleMetaException(FireworkEffectMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((FireworkEffectMeta)this.itemMeta).hasEffect();
    }

    /***
     * Sets the firework effect for this item. | Requires: Firework Effect Meta!
     * @param effect specify the firework effect to set
     */
    public ItemManager setEffect(FireworkEffect effect) {
        if(!(this.itemMeta instanceof FireworkEffectMeta)) try { throw new IncompatibleMetaException(FireworkEffectMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((FireworkEffectMeta)this.itemMeta).setEffect(effect);
        return this;
    }

    // ---------------------------------------- [       Firework Meta       ] ---------------------------------------- \\
    /***
     * Add another effect to this firework. | Requires: Firework Meta!
     * @param effect specify the effect to add
     */
    public ItemManager addFireworkEffect(FireworkEffect effect) {
        if(!(this.itemMeta instanceof FireworkMeta)) try { throw new IncompatibleMetaException(FireworkMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((FireworkMeta)this.itemMeta).addEffect(effect);
        return this;
    }

    /***
     * Add several firework effects to this firework. | Requires: Firework Meta!
     * @param effects specify the effects to add
     */
    public ItemManager addFireworkEffects(FireworkEffect...effects) {
        if(!(this.itemMeta instanceof FireworkMeta)) try { throw new IncompatibleMetaException(FireworkMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((FireworkMeta)this.itemMeta).addEffects(effects);
        return this;
    }

    /***
     * Get the effects in this firework. | Requires: Firework Meta!
     */
    public List<FireworkEffect> getFireworkEffects() {
        if(!(this.itemMeta instanceof FireworkMeta)) try { throw new IncompatibleMetaException(FireworkMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((FireworkMeta)this.itemMeta).getEffects();
    }

    /***
     * Get the number of effects in this firework. | Requires: Firework Meta!
     */
    public int getFireworkEffectsSize() {
        if(!(this.itemMeta instanceof FireworkMeta)) try { throw new IncompatibleMetaException(FireworkMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((FireworkMeta)this.itemMeta).getEffectsSize();
    }

    /***
     * Get the approximate height the firework will fly. | Requires: Firework Meta!
     */
    public int getFireworkPower() {
        if(!(this.itemMeta instanceof FireworkMeta)) try { throw new IncompatibleMetaException(FireworkMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((FireworkMeta)this.itemMeta).getPower();
    }

    /***
     * Get whether this firework has any effects. | Requires: Firework Meta!
     */
    public boolean hasFireworkEffects() {
        if(!(this.itemMeta instanceof FireworkMeta)) try { throw new IncompatibleMetaException(FireworkMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((FireworkMeta)this.itemMeta).hasEffects();
    }

    /***
     * Remove an effect from this firework. | Requires: Firework Meta!
     * @param i specify the effect index
     */
    public ItemManager removeFireworkEffect(int i) {
        if(!(this.itemMeta instanceof FireworkMeta)) try { throw new IncompatibleMetaException(FireworkMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((FireworkMeta)this.itemMeta).removeEffect(i);
        return this;
    }

    /***
     * SEts the approximate power of the firework. | Requires: Firework Meta!
     * @param power specify the fireworks power
     */
    public ItemManager setFireworkPower(int power) {
        if(!(this.itemMeta instanceof FireworkMeta)) try { throw new IncompatibleMetaException(FireworkMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((FireworkMeta)this.itemMeta).setPower(power);
        return this;
    }

    // ---------------------------------------- [    Knowledge Book Meta    ] ---------------------------------------- \\
    /***
     * Adds new recipes to the end of the book. | Requires: Knowledge Book Meta!
     * @param recipes specify the recipe(s) to add
     */
    public ItemManager addKnowledgeRecipes(NamespacedKey...recipes) {
        if(!(this.itemMeta instanceof KnowledgeBookMeta)) try { throw new IncompatibleMetaException(KnowledgeBookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((KnowledgeBookMeta)this.itemMeta).addRecipe(recipes);
        return this;
    }

    /***
     * Gets all the recipes in the book. | Requires: Knowledge Book Meta!
     */
    public List<NamespacedKey> getKnowledgeRecipes() {
        if(!(this.itemMeta instanceof KnowledgeBookMeta)) try { throw new IncompatibleMetaException(KnowledgeBookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((KnowledgeBookMeta)this.itemMeta).getRecipes();
    }

    /***
     * Checks for the existence of recipes in the book. | Requires: Knowledge Book Meta!
     */
    public boolean hasKnowledgeRecipes() {
        if(!(this.itemMeta instanceof KnowledgeBookMeta)) try { throw new IncompatibleMetaException(KnowledgeBookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((KnowledgeBookMeta)this.itemMeta).hasRecipes();
    }

    /***
     * Clears the existing book recipes and sets the book to use the provided recipes. | Requires: Knowledge Book Meta!
     * @param recipes specify the recipe(s)
     */
    public ItemManager setKnowledgeRecipes(NamespacedKey...recipes) {
        if(!(this.itemMeta instanceof KnowledgeBookMeta)) try { throw new IncompatibleMetaException(KnowledgeBookMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((KnowledgeBookMeta)this.itemMeta).setRecipes(Arrays.asList(recipes));
        return this;
    }

    // ---------------------------------------- [     Leather Armor Meta    ] ---------------------------------------- \\
    /***
     * Gets the color of the armor. | Requires: Leather Armor Meta!
     */
    public Color getLeatherColor() {
        if(!(this.itemMeta instanceof LeatherArmorMeta)) try { throw new IncompatibleMetaException(LeatherArmorMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((LeatherArmorMeta)this.itemMeta).getColor();
    }

    /***
     * Sets the color of the armor. | Requires: Leather Armor Meta!
     * @param color specify the color
     */
    public ItemManager setLeatherColor(Color color) {
        if(!(this.itemMeta instanceof LeatherArmorMeta)) try { throw new IncompatibleMetaException(LeatherArmorMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((LeatherArmorMeta)this.itemMeta).setColor(color);
        return this;
    }

    // ---------------------------------------- [          Map Meta         ] ---------------------------------------- \\
    /***
     * Gets the map color that is set. | Requires: Map Meta!
     */
    public Color getMapColor() {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((MapMeta)this.itemMeta).getColor();
    }

    /***
     * Gets the location name that is set. | Requires: Map Meta!
     */
    public String getMapLocationName() {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((MapMeta)this.itemMeta).getLocationName();
    }

    /***
     * Gets the id of this map. | Requires: Map Meta!
     */
    public int getMapID() {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((MapMeta)this.itemMeta).getMapId();
    }

    /***
     * Gets the map view that is associated with this map. | Requires: Map Meta!
     */
    public MapView getMapView() {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((MapMeta)this.itemMeta).getMapView();
    }

    /***
     * Checks for existence of a map color. | Requires: Map Meta!
     */
    public boolean hasMapColor() {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((MapMeta)this.itemMeta).hasColor();
    }

    /***
     * Checks for existence of a location name. | Requires: Map Meta!
     */
    public boolean hasMapLocationName() {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((MapMeta)this.itemMeta).hasLocationName();
    }

    /***
     * Checks for existence of a map id. | Requires: Map Meta!
     */
    public boolean hasMapId() {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((MapMeta)this.itemMeta).hasMapId();
    }

    /***
     * Checks for existence of an associated map. | Requires: Map Meta!
     */
    public boolean hasMapView() {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((MapMeta)this.itemMeta).hasMapView();
    }

    /***
     * Checks to see if this map is scaling. | Requires: Map Meta!
     */
    public boolean isMapScaling() {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((MapMeta)this.itemMeta).isScaling();
    }

    /***
     * Sets the map color of this map. | Requires: Map Meta!
     * @param color specify the color
     */
    public ItemManager setMapColor(Color color) {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((MapMeta)this.itemMeta).setColor(color);
        return this;
    }

    /***
     * Sets the location name. | Requires: Map Meta!
     * @param name specify the location name
     */
    public ItemManager setMapLocationName(String name) {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((MapMeta)this.itemMeta).setLocationName(name);
        return this;
    }

    /***
     * Sets the map id of this map. | Requires: Map Meta!
     * @param id specify the map id
     */
    public ItemManager setMapId(int id) {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((MapMeta)this.itemMeta).setMapId(id);
        return this;
    }

    /***
     * Sets the associated map. | Requires: Map Meta!
     * @param map specify the associated map
     */
    public ItemManager setMapView(MapView map) {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((MapMeta)this.itemMeta).setMapView(map);
        return this;
    }

    /***
     * Sets if this map is scaling or not. | Requires: Map Meta!
     * @param value specify if the map should be scaling
     */
    public ItemManager setMapScaling(boolean value) {
        if(!(this.itemMeta instanceof MapMeta)) try { throw new IncompatibleMetaException(MapMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((MapMeta)this.itemMeta).setScaling(value);
        return this;
    }

    // ---------------------------------------- [        Potion Meta        ] ---------------------------------------- \\
    /***
     * Adds a custom potion effect to this potion. | Requires: Potion Meta!
     * @param effect specify the effect
     * @param overwrite specify whether the effect should be overwritten
     */
    public ItemManager addCustomPotionEffect(PotionEffect effect, boolean overwrite) {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((PotionMeta)this.itemMeta).addCustomEffect(effect, overwrite);
        return this;
    }

    /***
     * Removes all custom potion effects from this potion. | Requires: Potion Meta!
     */
    public ItemManager clearCustomPotionEffects() {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((PotionMeta)this.itemMeta).clearCustomEffects();
        return this;
    }

    /***
     * Returns the potion data about the base potion. | Requires: Potion Meta!
     */
    public PotionData getBasePotionData() {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((PotionMeta)this.itemMeta).getBasePotionData();
    }

    /***
     * Gets the potion color that is set. | Requires: Potion Meta!
     */
    public Color getPotionColor() {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((PotionMeta)this.itemMeta).getColor();
    }

    /***
     * Gets an immutable list containing all custom potion effects applied to this potion. | Requires: Potion Meta!
     */
    public List<PotionEffect> getCustomPotionEffects() {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((PotionMeta)this.itemMeta).getCustomEffects();
    }

    /***
     * Checks for existence of a potion color. | Requires: Potion Meta!
     */
    public boolean hasPotionColor() {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((PotionMeta)this.itemMeta).hasColor();
    }

    /***
     * Checks for a specific custom potion effect on this potion. | Requires: Potion Meta!
     */
    public boolean hasCustomPotionEffect(PotionEffectType type) {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((PotionMeta)this.itemMeta).hasCustomEffect(type);
    }

    /***
     * Checks for the presence of custom potion effects. | Requires: Potion Meta!
     */
    public boolean hasCustomPotionEffects() {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((PotionMeta)this.itemMeta).hasCustomEffects();
    }

    /***
     * Removes a custom potion effect from this potion. | Requires: Potion Meta!
     * @param type specify the type
     */
    public ItemManager removeCustomPotionEffect(PotionEffectType type) {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((PotionMeta)this.itemMeta).removeCustomEffect(type);
        return this;
    }

    /***
     * Removes a custom potion effect from this potion. | Requires: Potion Meta!
     * @param data specify the base potion data
     */
    public ItemManager setBasePotionData(PotionData data) {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((PotionMeta)this.itemMeta).setBasePotionData(data);
        return this;
    }

    /***
     * Removes a custom potion effect from this potion. | Requires: Potion Meta!
     * @param color specify the color
     */
    public ItemManager setPotionColor(Color color) {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((PotionMeta)this.itemMeta).setColor(color);
        return this;
    }

    /***
     * Removes a custom potion effect from this potion. | Requires: Potion Meta!
     * @param type specify the main effect type
     */
    @Deprecated
    public ItemManager setMainPotionEffect(PotionEffectType type) {
        if(!(this.itemMeta instanceof PotionMeta)) try { throw new IncompatibleMetaException(PotionMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((PotionMeta)this.itemMeta).setMainEffect(type);
        return this;
    }

    // ---------------------------------------- [        Skull Meta         ] ---------------------------------------- \\
    /***
     * Gets the owner of the skull. | Requires: Skull Meta!
     */
    public OfflinePlayer getSkullOwningPlayer() {
        if(!(this.itemMeta instanceof SkullMeta)) try { throw new IncompatibleMetaException(SkullMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((SkullMeta)this.itemMeta).getOwningPlayer();
    }

    /***
     * Checks to see if the skull has an owner. | Requires: Skull Meta!
     */
    public boolean hasSkullOwner() {
        if(!(this.itemMeta instanceof SkullMeta)) try { throw new IncompatibleMetaException(SkullMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((SkullMeta)this.itemMeta).hasOwner();
    }

    /***
     * Sets the owner of the skull. | Requires: Skull Meta!
     * @param owner specify the skull owner
     */
    public ItemManager setSkullOwningPlayer(OfflinePlayer owner) {
        if(!(this.itemMeta instanceof SkullMeta)) try { throw new IncompatibleMetaException(SkullMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((SkullMeta)this.itemMeta).setOwningPlayer(owner);
        return this;
    }

    // ---------------------------------------- [    Suspicious Stew Meta   ] ---------------------------------------- \\
    /***
     * Adds a custom potion effect to thi suspicious stew. | Requires: Suspicious Stew Meta!
     * @param effect specify the potion effect
     * @param overwrite specify whether the effect should be overwritten
     */
    public ItemManager addCustomStewEffect(PotionEffect effect, boolean overwrite) {
        if(!(this.itemMeta instanceof SuspiciousStewMeta)) try { throw new IncompatibleMetaException(SuspiciousStewMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((SuspiciousStewMeta)this.itemMeta).addCustomEffect(effect, overwrite);
        return this;
    }

    /***
     * Removes all custom potion effects from this suspicious stew. | Requires: Suspicious Stew Meta!
     */
    public ItemManager clearCustomStewEffects() {
        if(!(this.itemMeta instanceof SuspiciousStewMeta)) try { throw new IncompatibleMetaException(SuspiciousStewMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((SuspiciousStewMeta)this.itemMeta).clearCustomEffects();
        return this;
    }

    /***
     * Gets an immutable list containing all custom potion effects applied to this suspicious stew. | Requires: Suspicious Stew Meta!
     */
    public List<PotionEffect> getCustomStewEffects() {
        if(!(this.itemMeta instanceof SuspiciousStewMeta)) try { throw new IncompatibleMetaException(SuspiciousStewMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((SuspiciousStewMeta)this.itemMeta).getCustomEffects();
    }

    /***
     * Checks for a specific custom potion effect type on this suspicious stew. | Requires: Suspicious Stew Meta!
     * @param type specify the effect type
     */
    public boolean hasCustomStewEffect(PotionEffectType type) {
        if(!(this.itemMeta instanceof SuspiciousStewMeta)) try { throw new IncompatibleMetaException(SuspiciousStewMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((SuspiciousStewMeta)this.itemMeta).hasCustomEffect(type);
    }

    /***
     * Checks for the presence of custom potion effects. | Requires: Suspicious Stew Meta!
     */
    public boolean hasCustomStewEffects() {
        if(!(this.itemMeta instanceof SuspiciousStewMeta)) try { throw new IncompatibleMetaException(SuspiciousStewMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((SuspiciousStewMeta)this.itemMeta).hasCustomEffects();
    }

    /***
     * Removes a custom potion effect from this suspicious stew. | Requires: Suspicious Stew Meta!
     * @param type specify the effect type
     */
    public ItemManager removeCustomStewEffects(PotionEffectType type) {
        if(!(this.itemMeta instanceof SuspiciousStewMeta)) try { throw new IncompatibleMetaException(SuspiciousStewMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((SuspiciousStewMeta)this.itemMeta).removeCustomEffect(type);
        return this;
    }

    // ---------------------------------------- [ Tropical Fish Bucket Meta ] ---------------------------------------- \\
    /***
     * Gets the color of the fish's body. | Requires: Tropical Fish Bucket Meta!
     */
    public DyeColor getTropicalFishBodyColor() {
        if(!(this.itemMeta instanceof TropicalFishBucketMeta)) try { throw new IncompatibleMetaException(TropicalFishBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((TropicalFishBucketMeta)this.itemMeta).getBodyColor();
    }

    /***
     * Gets the fish's pattern. | Requires: Tropical Fish Bucket Meta!
     */
    public TropicalFish.Pattern getTropicalFishPattern() {
        if(!(this.itemMeta instanceof TropicalFishBucketMeta)) try { throw new IncompatibleMetaException(TropicalFishBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((TropicalFishBucketMeta)this.itemMeta).getPattern();
    }

    /***
     * Gets the color of the fish's pattern. | Requires: Tropical Fish Bucket Meta!
     */
    public DyeColor getTropicalFishPatternColor() {
        if(!(this.itemMeta instanceof TropicalFishBucketMeta)) try { throw new IncompatibleMetaException(TropicalFishBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((TropicalFishBucketMeta)this.itemMeta).getPatternColor();
    }

    /***
     * Checks for existence of a variant tag indicating a specific fish will be spawned. | Requires: Tropical Fish Bucket Meta!
     */
    public boolean hasTropicalFishVariant() {
        if(!(this.itemMeta instanceof TropicalFishBucketMeta)) try { throw new IncompatibleMetaException(TropicalFishBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        return ((TropicalFishBucketMeta)this.itemMeta).hasVariant();
    }

    /***
     * Sets the color of the fish's body. | Requires: Tropical Fish Bucket Meta!
     * @param color specify the fish's body color
     */
    public ItemManager setTropicalFishBodyColor(DyeColor color) {
        if(!(this.itemMeta instanceof TropicalFishBucketMeta)) try { throw new IncompatibleMetaException(TropicalFishBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((TropicalFishBucketMeta)this.itemMeta).setBodyColor(color);
        return this;
    }

    /***
     * Sets the fish's pattern. | Requires: Tropical Fish Bucket Meta!
     * @param pattern specify the fish's pattern
     */
    public ItemManager setTropicalFishPatternColor(TropicalFish.Pattern pattern) {
        if(!(this.itemMeta instanceof TropicalFishBucketMeta)) try { throw new IncompatibleMetaException(TropicalFishBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((TropicalFishBucketMeta)this.itemMeta).setPattern(pattern);
        return this;
    }

    /***
     * Sets the color of the fish's pattern. | Requires: Tropical Fish Bucket Meta!
     * @param color specify the pattern's color
     */
    public ItemManager setTropicalFishPatternColor(DyeColor color) {
        if(!(this.itemMeta instanceof TropicalFishBucketMeta)) try { throw new IncompatibleMetaException(TropicalFishBucketMeta.class, itemMeta.getClass()); } catch (IncompatibleMetaException e) { e.printStackTrace(); }
        ((TropicalFishBucketMeta)this.itemMeta).setPatternColor(color);
        return this;
    }

    // ---------------------------------------- [           Custom          ] ---------------------------------------- \\
    /***
     * Processes changes and returns a default Spigot item.
     */
    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}


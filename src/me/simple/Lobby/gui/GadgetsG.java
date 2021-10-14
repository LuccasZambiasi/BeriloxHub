package me.simple.Lobby.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.simple.Lobby.Main;

public class GadgetsG implements Listener{
	
	public void SetarInv(Inventory inv, Player p, Material item, int quantidade, int data, int slot, String descricao, String nome) {
		ItemStack icone = new ItemStack(item, quantidade, (short)data);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName(nome);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(descricao);
		iconem.setLore(lore);
		icone.setItemMeta(iconem);
		inv.setItem(slot, icone);
	}
	
	public void gadgetsgui(Player p) {
		
		Inventory inv = Bukkit.createInventory(p, 9, Main.cor + "Gadgets");
		
		ItemStack icone = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName(" ");
		icone.setItemMeta(iconem);
		icone.setAmount(1);
		
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 1, "", " ");
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 3, "", " ");
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 5, "", " ");
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 7, "", " ");
		SetarInv(inv, p, Material.DIAMOND_HELMET, 1, 0, 2, Main.cor + "Veja os servidores!", Main.cor + "Cabeças §8§l(" + Main.cor2 + "Clique§8§l)");
		SetarInv(inv, p, Material.BLAZE_POWDER, 1, 0, 4, Main.cor +  "Coloque diversos efeitos!", Main.cor + "§lEfeitos §8§l(" + Main.cor2 + "Clique§8§l) ");
	    SetarInv(inv, p, Material.LEATHER_CHESTPLATE, 1, 0, 6, Main.cor + "Mude de roupas!", Main.cor + "Roupas §8§l(" + Main.cor2 + "Clique§8§l)");
	    SetarInv(inv, p, Material.DIAMOND_LEGGINGS, 1, 0, 8, Main.cor + "Tire suas roupas!", Main.cor + "Remover Roupas §8§l(" + Main.cor2 + "Clique§8§l)");
		
		for (int i = 0; i < 1; i++) {
			inv.addItem(icone);
		}
		
		p.openInventory(inv);
	}
	
	@EventHandler
	private void clickBau(PlayerInteractEvent Twork) {
		Player jogador = Twork.getPlayer();
		
		if (Twork.getAction() == Action.RIGHT_CLICK_AIR && jogador.getItemInHand().getType() == Material.FIREWORK) {
			gadgetsgui(jogador);
			jogador.playSound(jogador.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Twork.setCancelled(true);
		}
	}
	
	@EventHandler
	public void  ClicarInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase(Main.cor + "Gadgets")) {
			p.closeInventory();
			if (e.getCurrentItem() == null);
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.cor + "Remover Roupas §8§l(" + Main.cor2 + "Clique§8§l)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(Main.cor + "LOBBY§7: Armadura removida :) ");
				p.getInventory().setArmorContents(null);
				return;
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.cor + "Efeitos §8§l(" + Main.cor2 + "Clique§8§l)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(Main.cor + "LOBBY§7: EM BREVE");
				return;
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.cor + "Cabeças §8§l(" + Main.cor2 + "Clique§8§l)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§eEm desenvolvimento");
				return;
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.cor + "Roupas §8§l(" + Main.cor2 + "Clique§8§l)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(Main.cor + "LOBBY§7: Armadura adquirida :) ");
				 ItemStack Capacete = new ItemStack(Material.DIAMOND_HELMET);
			      ItemMeta kCapacete = (ItemMeta)Capacete.getItemMeta();
			      Capacete.setItemMeta(kCapacete);
					 ItemStack Peito = new ItemStack(Material.GOLD_CHESTPLATE);
				      ItemMeta kPeito = (ItemMeta)Peito.getItemMeta();
				      Peito.setItemMeta(kPeito);
						 ItemStack Leggs = new ItemStack(Material.LEATHER_LEGGINGS);
					      ItemMeta kLeggs = (ItemMeta)Leggs.getItemMeta();
					      Leggs.setItemMeta(kLeggs);
							 ItemStack Bots = new ItemStack(Material.IRON_BOOTS);
						      ItemMeta kBots = (ItemMeta)Bots.getItemMeta();
						      Bots.setItemMeta(kBots);
			      p.getInventory().setHelmet(Capacete);
			      p.getInventory().setChestplate(Peito);
			      p.getInventory().setLeggings(Leggs);
			      p.getInventory().setBoots(Bots);
			      
				return;
			}
			
		}
		
		if (e.getCurrentItem().getType() == Material.AIR) {
			e.setCancelled(true);
			return;
		}
		
		
	}

}

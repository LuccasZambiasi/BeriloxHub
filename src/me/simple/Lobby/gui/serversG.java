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

public class serversG implements Listener{
	
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
		
		Inventory inv = Bukkit.createInventory(p, 9, Main.cor + "Servidores");
		
		ItemStack icone = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName(" ");
		icone.setItemMeta(iconem);
		icone.setAmount(1);
		
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 1, "", " ");
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 3, "", " ");
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 5, "", " ");
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 3, "", " ");
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 7, "", " ");
		SetarInv(inv, p, Material.STAINED_GLASS_PANE, 1, 0, 8, "", " ");
		SetarInv(inv, p, Material.DIAMOND_SWORD, 1, 0, 2, Main.cor + "Clique para entrar nos servidores de PVP", Main.cor + Main.KitPvP_Name + " §8§l(" + Main.cor2 + "Connect§8§l)");
		SetarInv(inv, p, Material.GOLD_SWORD, 1, 0, 4, Main.cor +  "Clique para entrar nos servidores de FULLPVP", Main.cor + Main.FullPvP_Name + " §8§l(" + Main.cor2 + "Connect§8§l)");
	    SetarInv(inv, p, Material.MUSHROOM_SOUP, 1, 0, 6, Main.cor + "Clique para entrar nos seridores de HG", Main.cor + Main.Hg_Name + " §8§l(" + Main.cor2 + "Connect§8§l)");
		
		for (int i = 0; i < 1; i++) {
			inv.addItem(icone);
		}
		
		p.openInventory(inv);
	}
	
	@EventHandler
	private void clickBau(PlayerInteractEvent Twork) {
		Player jogador = Twork.getPlayer();
		
		if (Twork.getAction() == Action.RIGHT_CLICK_AIR && jogador.getItemInHand().getType() == Material.COMPASS) {
			gadgetsgui(jogador);
			jogador.playSound(jogador.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Twork.setCancelled(true);
		}
	}
	
	@EventHandler
	public void  ClicarInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase(Main.cor + "Servidores")) {
			p.closeInventory();
			if (e.getCurrentItem() == null);
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.cor + Main.KitPvP_Name + " §8§l(" + Main.cor2 + "Connect§8§l)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/server kitpvp");
				return;
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.cor + Main.FullPvP_Name + " §8§l(" + Main.cor2 + "Connect§8§l)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/server fullpvp");
				return;
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.cor + Main.Hg_Name + " §8§l(" + Main.cor2 + "Connect§8§l)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/server hg");
				return;
			}
			
		}
		
		if (e.getCurrentItem().getType() == Material.AIR) {
			e.setCancelled(true);
			return;
		}
		
		
	}

}

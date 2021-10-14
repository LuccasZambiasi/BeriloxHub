package me.simple.Lobby.Board;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import me.simple.Lobby.Main;

@SuppressWarnings("deprecation")
public class Scoreboarding implements Listener{
	
	public static void ScoreboardManager(Player p) {
		
		Scoreboard Board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective Obj = Board.registerNewObjective("Score", "Board");
		Obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Obj.setDisplayName(Main.Score_Name);
		Score a17 = Obj.getScore(Bukkit.getOfflinePlayer("§7      " + Main.Ip_Da_Score));
		Score a16 = Obj.getScore(Bukkit.getOfflinePlayer("§3 §7§m ▀ ▀ ▀ ▀ ▀   "));
		Score a15 = Obj.getScore(Bukkit.getOfflinePlayer("§e  "));
		Score a14 = Obj.getScore(Bukkit.getOfflinePlayer("§7Info:"));
		Score a13 = Obj.getScore(Bukkit.getOfflinePlayer("§b  "));
		Score a12 = Obj.getScore(Bukkit.getOfflinePlayer(Main.KitPvP_Name +" §6» " + Main.Stats_Kitpvp));
		Score a11 = Obj.getScore(Bukkit.getOfflinePlayer(Main.Hg_Name + "§6» " + Main.Stats_Hg));
		Score a10 = Obj.getScore(Bukkit.getOfflinePlayer(Main.FullPvP_Name + "§6» " + Main.Stats_FullPvP));
		Score a9 = Obj.getScore(Bukkit.getOfflinePlayer("§a "));
		Score a8 = Obj.getScore(Bukkit.getOfflinePlayer("§fNovidade §6» " + Main.novidade));
		Score a7 = Obj.getScore(Bukkit.getOfflinePlayer("§fConectado: " + Main.connect));
		Score a6 = Obj.getScore(Bukkit.getOfflinePlayer("§e"));
		Score a5 = Obj.getScore(Bukkit.getOfflinePlayer("§7/score"));
		
		a17.setScore(17);
		a16.setScore(16);
		a15.setScore(15);
		a14.setScore(14);
		a13.setScore(13);
		a12.setScore(12);
		a11.setScore(11);
		a10.setScore(10);
		a9.setScore(9);
		a8.setScore(8);
		a7.setScore(7);
		a6.setScore(6);
		a5.setScore(5);
		
		p.setScoreboard(Board);
	}
	

}
import 'dart:convert';

import 'package:P4/models/lastMatch.dart';
import 'package:P4/models/matchV4.dart';
import 'package:P4/utility/NetworkHelper.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter/rendering.dart';


class History extends StatelessWidget {

  String nick;
  matchV4 matches = new matchV4();
  lastMatch Match = new lastMatch();


  History({Key key, @required this.matches, @required this.nick, @required this.Match}) : super(key: key);

  @override
  Widget build(BuildContext context) {
      return Scaffold(
        backgroundColor: Colors.blue,
        body: Column(children: [
          Expanded(
              child: Center(child: Image.network("https://upload.wikimedia.org/wikipedia/pt/b/b5/League_of_Legends_logo_2019.png", width: 350,))
          ),
          Expanded(child: Text("Olá, " + nick + "! Essa foi a sua última partida:", style: TextStyle(fontSize: 28, color: Colors.white),)),
          Expanded(
            child: Column(
              children: [
                Text("GAME ID: " + Match.gameId.toString() ,style: TextStyle(fontSize: 30, color: Colors.white)),
                Text("GAMEMODE: " + Match.gameMode, style: TextStyle(fontSize: 30, color: Colors.white)),
                Text("KILLS TIME AZUL: " + (Match.participants[0].stats.kills + Match.participants[1].stats.kills + Match.participants[2].stats.kills + Match.participants[3].stats.kills + Match.participants[4].stats.kills).toString() ,style: TextStyle(fontSize: 30, color: Colors.white)),
                Text("ASSISTÊNCIAS TIME AZUL: " + (Match.participants[0].stats.assists + Match.participants[1].stats.assists + Match.participants[2].stats.assists + Match.participants[3].stats.assists + Match.participants[4].stats.assists).toString() ,style: TextStyle(fontSize: 30, color: Colors.white)),
                Text("MORTES TIME AZUL: " + (Match.participants[0].stats.deaths + Match.participants[1].stats.deaths + Match.participants[2].stats.deaths + Match.participants[3].stats.deaths + Match.participants[4].stats.deaths).toString() ,style: TextStyle(fontSize: 30, color: Colors.white)),
                Text("KILLS TIME VERMELHO: " + (Match.participants[5].stats.kills + Match.participants[6].stats.kills + Match.participants[7].stats.kills + Match.participants[8].stats.kills + Match.participants[9].stats.kills).toString() ,style: TextStyle(fontSize: 30, color: Colors.white)),
                Text("ASSISTÊNCIAS TIME VERMELHO: " + (Match.participants[5].stats.assists + Match.participants[6].stats.assists + Match.participants[7].stats.assists + Match.participants[8].stats.assists + Match.participants[9].stats.assists).toString() ,style: TextStyle(fontSize: 30, color: Colors.white)),
                Text("MORTES TIME AZUL: " + (Match.participants[5].stats.deaths + Match.participants[6].stats.deaths + Match.participants[7].stats.deaths + Match.participants[8].stats.deaths + Match.participants[9].stats.deaths).toString() ,style: TextStyle(fontSize: 30, color: Colors.white)),
              ],
            ),
          ),

    ]),
    );
  }
}

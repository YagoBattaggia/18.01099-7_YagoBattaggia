import 'dart:convert';

import 'package:P4/models/lastMatch.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';


import 'package:P4/models/matchV4.dart';
import 'package:P4/models/summonerV4.dart';
import 'package:P4/utility/NetworkHelper.dart';
import 'package:P4/modules/history/history.dart';

class HomePage extends StatefulWidget {


  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<HomePage> {

  matchV4 matches = new matchV4();
  lastMatch last = new lastMatch();
  final controladorNick = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blue,
      body:   Column(children: [
       Expanded(
        child: Center(child: Image.network("https://upload.wikimedia.org/wikipedia/pt/b/b5/League_of_Legends_logo_2019.png", width: 350,))
        ),

        Expanded(
          child:Text(
          "League of Legends History",
          style: TextStyle(fontSize: 30, height: 4, color: Colors.white),
        ),
        ),
        txtField(controladorNick),
        Expanded(child: Center(child: Text("Algumas contas que podem ser utilizadas para teste: Ttya, VortemBR, Nick147jr", style: TextStyle(fontSize: 20, height: 4, color: Colors.black26),))),
        Expanded(
          child: ElevatedButton(onPressed: () async {
            await getHistory();
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) =>
                  History(matches: this.matches,nick: controladorNick.text, Match: last,)),
            );
          }, child: Text("Clique Aqui!")
          ),
        )
      ]),
    );
  }
  Future<String> getHistory() async {
    var apiKey = "RGAPI-eb286488-a7af-43ce-9eba-6035d2d2c3ef";
    var requisicao = NetworkHelper(url: "https://br1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + controladorNick.text + "?api_key=" + apiKey);
    var json = summonerV4.fromJson(await requisicao.getData());
    var accountId = json.accountId;
    var requisicaoMatchList = NetworkHelper(url: "https://br1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId + "?api_key=" + apiKey);
    var json2 = matchV4.fromJson(await requisicaoMatchList.getData());
    print(json2.matches[0].gameId);
    matches.matches = json2.matches;
    var requisicaoLastMatch = NetworkHelper(url: "https://br1.api.riotgames.com/lol/match/v4/matches/" + json2.matches[10].gameId.toString() + "?api_key=" + apiKey);
    var json3 = lastMatch.fromJson(await requisicaoLastMatch.getData());
    print(json3.gameDuration.toString());
    last = json3;

  }
}

Widget txtField(TextEditingController nick){
  return Expanded(
    child: Padding(
      padding: EdgeInsets.all(70.0),
      child: TextField(
      controller: nick,
      decoration: InputDecoration(
        hintText: 'Insira o seu Nick no League of Legends',
        hintStyle: TextStyle(color: Colors.white),
        // border: const OutlineInputBorder(borderSide: BorderSide(color: Colors.white, width: 2.0, style: BorderStyle.solid ), borderRadius: BorderRadius.all(Radius.circular(3.0))),
      ),
      ),
    ),
  );
}
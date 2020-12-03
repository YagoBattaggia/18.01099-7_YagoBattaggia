import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

//Import de páginas
import 'package:P4/modules/home/homePage.dart';
import 'package:P4/modules/history/history.dart';

void main(){
  runApp(MaterialApp(
    initialRoute: '/',
    routes: {
      '/': (context) => HomePage(),
    },
  ),
  );
}

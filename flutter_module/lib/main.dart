import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  void initState() {
    super.initState();

    _alertUserAfter(const Duration(seconds: 3));
  }

  @override
  Widget build(BuildContext context) => const Opacity(opacity: 0);

  void _alertUserAfter(Duration delay) {
    Future.delayed(delay).then((_) => showDialog(
        context: context,
        builder: (BuildContext context) => AlertDialog(
              title: const Text("Testing WGO-835"),
              content: SingleChildScrollView(
                child: ListBody(
                  children: const [
                    Text("This is a demo alert"),
                    Text("Click OK")
                  ],
                ),
              ),
              actions: [
                TextButton(
                  child: const Text("OK"),
                  onPressed: () {
                    Navigator.of(context).pop();
                  },
                )
              ],
            )));
  }
}

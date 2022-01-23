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
  bool _showingDialog = false;

  @override
  void initState() {
    super.initState();

    _alertUserAfter(const Duration(seconds: 5));
  }

  @override
  Widget build(BuildContext context) => _showingDialog
      ? Container(color: Colors.red.withOpacity(0))
      : const Opacity(opacity: 0);

  void _alertUserAfter(Duration delay) async {
    await Future.delayed(delay);

    setState(() {
      _showingDialog = true;
    });

    await showDialog(
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
            ));

    setState(() {
      _showingDialog = false;
    });
  }
}

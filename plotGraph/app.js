google.charts.load("current", { packages: ["corechart", "line"] });
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {
  var data = new google.visualization.DataTable();
  data.addColumn("number", "X");
  data.addColumn("number", "Time");

  /* This part is to be replaced after the execution of Java Program */

  data.addRows([[10, 0.0086], [20, 0.0063], [30, 0.0101], [40, 0.0148], [50, 0.023], [60, 0.025]]);
  /* --- */

  var options = {
    hAxis: {
      title: "Input Size",
    },
    curveType: 'function',
    vAxis: {
      title: "Time (ms)",
    },
    height: window.innerHeight / 1.5,
  };

  var chart = new google.visualization.LineChart(
    document.getElementById("chart_div")
  );

  chart.draw(data, options);
}

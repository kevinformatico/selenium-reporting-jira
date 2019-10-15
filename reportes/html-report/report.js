$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/BusquedaGoogle.feature");
formatter.feature({
  "name": "Busqueda",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@busquedaGoogle"
    }
  ]
});
formatter.scenarioOutline({
  "name": "busqueda en Google",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TestCaseKey\u003dJIRA-T1"
    }
  ]
});
formatter.step({
  "name": "Estoy en la pagina \"http://www.google.cl\"",
  "keyword": "Given "
});
formatter.step({
  "name": "busco la palabra \"\u003cbuscar\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "aparecen enlaces relacionados con \"\u003cbuscar\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "hacer click en el enlace",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "buscar"
      ]
    },
    {
      "cells": [
        "Autos"
      ]
    }
  ]
});
formatter.scenario({
  "name": "busqueda en Google",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@busquedaGoogle"
    },
    {
      "name": "@TestCaseKey\u003dJIRA-T1"
    }
  ]
});
formatter.step({
  "name": "Estoy en la pagina \"http://www.google.cl\"",
  "keyword": "Given "
});
formatter.match({
  "location": "BusquedaEnGoogle.estoy_en_la_pagina(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "busco la palabra \"Autos\"",
  "keyword": "When "
});
formatter.match({
  "location": "BusquedaEnGoogle.busco_la_palabra(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "aparecen enlaces relacionados con \"Autos\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BusquedaEnGoogle.aparecen_enlaces_relacionados_con(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "hacer click en el enlace",
  "keyword": "And "
});
formatter.match({
  "location": "BusquedaEnGoogle.hacer_click_en_el_enlace()"
});
formatter.result({
  "status": "passed"
});
});
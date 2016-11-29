Supported Platform
==================

Android Only

Installation
============

``cordova plugin add https://github.com/six519/cordova-plugin-sound-meter.git``

or via npm

``cordova plugin add cordova-plugin-sound-meter``

Usage
=====
::

    window.soundMeterPlugin.getAmplitude(function(e){
        //success callback
        alert(e["amplitude"]);
    }, function(e){
        //error callback
        alert('The error is: ' + e);
    });
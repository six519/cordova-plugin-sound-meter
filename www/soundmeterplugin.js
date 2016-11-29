"use strict";

var exec = require("cordova/exec");

var soundMeterPlugin = {
	getAmplitude: function(sc, ec) {
		exec(sc, ec, "SoundMeterPlugin", "getAmplitude", []);
	}
};

module.exports = soundMeterPlugin;
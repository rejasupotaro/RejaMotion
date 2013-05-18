(function() {
  var Hybridge = new function() {
    var HYBRIDGE_VERSION = "1.0";
    var HYBRIDGE_ID_PREFIX = "bridge.";

    var self = function Hybridge() {
      self.ids = {};
      self.idsCount = 0;
      self.callbackTable = {};
      self.observerTable = {};
    };

    self.prototype = {
      constructor: self,
      call: function(dest, params, callback) {
        if (typeof(params) == 'function') {
          callback = params;
          params = {};
        }

        var request = {
          'id': this._getId(),
          'dest': dest,
          'params': params
        };

        this._notifyToDevice(request, callback);
      },
      observe: function(dest, observer) {
        if (!dest && !observer) return;
        self.observer[dest] = (observer);
      },
      notifyToDevice: function(request, callback) {
        var requestJson = JSON.stringify(request);
        if (callback && request.id) {
          self.callbackTable[request.id] = callback;
        }

        if (this._existsDeviceBridge()) {
          window.DeviceBridge.notifyToDevice(encodeURIComponent(requestJson));
        } else {
          // TODO stack request from web
        }
      },
      returnToDevice: function() {
        // TODO impl me
      },
      notifyToWeb: function(notify) {
        json = JSON.parse(decodeURIComponent(notify));
        var observer = self.observerTable[json.dest];
        this.observer(json);
        // TODO returnToDevice
      },
      returnToWeb: function(notify) {
        json = JSON.parse(decodeURIComponent(notify));
        var callback = self.callbackTable[json.id];
        if (callback) callback(json.result);
        delete self.callbackTable[json.id];
      },
      getId: function() {
        var id = HYBRIDGE_ID_PREFIX + self.idsCount;
        self.ids[id] = true;
        self.idsCount++;
        return id;
      },
      existsDeviceBridge: function() {
        return !!(window.DeviceBridge);
      }
    };

    return self;
  };

  window.hybridge = new Hybridge();
}).call(this);

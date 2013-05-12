try
  requestJson = {
    'id': '1',
    'dest': 'system.toast.show',
    'params': { 'message': 'message from js' }
  }
  Device.notifyToDevice(JSON.stringify(requestJson))
catch referenceError
  console.log(referenceError);



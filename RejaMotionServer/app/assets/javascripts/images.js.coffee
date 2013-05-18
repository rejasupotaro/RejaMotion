try
  hybridge.call(
      'system.toast.show',
      {'message': 'message from js'},
      (result) -> alert(result.message))
catch referenceError
  console.log(referenceError);



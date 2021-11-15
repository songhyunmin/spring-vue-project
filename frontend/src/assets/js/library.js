
export default{
    install(Vue){
        Vue.prototype.$promiseGet = function (api) {
          return new Promise(function (resolve, reject) {
              $.get(api, function (response) {
                  if (response) {
                      resolve(response);
                  }
                  reject(new Error("Request is failed"));
              });
          });
        }

        Vue.prototype.$renew = function (val){ /* eslint-env jquery */
          return val ? JSON.parse(JSON.stringify(val)) : '';
        }

        Vue.prototype.$fileExist = function (f) {
            let path = null; // eslint-disable-line no-unused-vars
            let result = false;
            try {
              path = require(f);
              result = true;
            } catch {
              result = false;
            }

            return result;
        }

        Vue.prototype.$naverMap = function (addr, addrDetail) {
            window.open('http://maps.naver.com/?query=' + addr + ' ' + addrDetail, '_system');
        }

        Vue.prototype.$daumMap = function (addr, addrDetail) {
            window.open('http://local.daum.net/map/index.jsp?q=' + addr + ' ' + addrDetail, '_system');
        }

        Vue.prototype.$getNow = function (type) {
          let returnValue = '';
          let d = new Date();
          const year = d.getFullYear();
          let month = d.getMonth() + 1;
          let day = d.getDate();
          let hours = d.getHours();
          let minutes = d.getMinutes();
          let seconds = d.getSeconds();
  
          if (month < 10)
              month = '0' + month;
  
          if (day < 10)
              day = '0' + day;
  
          if (hours < 10)
              hours = '0' + hours;
  
          if (minutes < 10)
              minutes = '0' + minutes;
  
          if (seconds < 10)
              seconds = '0' + seconds;
  
          switch (type) {
              case 'yyyy':
                  returnValue = year;
                  break;
  
              case 'MM':
                  returnValue = month;
                  break;
  
              case 'dd':
                  returnValue = day;
                  break;
  
              case 'yyyyMMdd':
                  returnValue = year + '' + month + '' + day;
                  break;
  
              case 'yyyyMMddhh':
                  returnValue = year + '' + month + '' + day + '' + hours;
                  break;
  
              case 'yyyyMMddhhmmss':
                  returnValue = year + '' + month + '' + day + '' + hours + '' + minutes + '' + seconds;
                  break;
  
              default:
                  returnValue = year + '-' + month + '-' + day;
                  break;
          }
  
          return returnValue;
      }
    }
}
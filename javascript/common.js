
/**
 * 쿠키이름, 값, 만료일(일일 기준)으로 쿠키를 생성하며 결과를 객체로 반환함
 * @param {string} cookieName 
 * @param {string} data 
 * @param {Date} expire 
 * @returns
 */
function addCookie(cookieName, data, expire) {
  let expireDate =  new Date();
  expireDate.setDate(expireDate.getDate() + expire);
  document.cookie = `${cookieName}=${data};expires=${expireDate.toUTCString()}`;
  return {
    status : true,
    message : cookieName + " 쿠키 생성 완료"
  }
}

/**
 * 쿠키이름을 매개변수로 해당 쿠키를 찾아 존재여부를 객체로 반환합니다. 만약 존재한다면 쿠키의 값을 포함하여 리턴합니다.
 * @param {string} cookieName 
 */
function findCookie(cookieName) {
  let cookies = document.cookie;
  cookies = cookies.split(";");
  for(let find in cookies) {
    cookieArr = cookies[find].trim().split("=");
    if(cookieArr[0] == cookieName) {
      return {
        status : true,
        message : "쿠키가 존재합니다.",
        cookieVal : cookieArr[1]
      };
    }
  }
  return {
    status : false,
    message : "쿠키가 존재하지 않습니다.",
    cookieVal : undefined
  };
}

/**
 * 쿠키이름을 매개변수로 해당 쿠키를 삭제합니다 삭제여부를 객체로 반환합니다
 * @param {string} cookieName
 */
function deleteCookie(cookieName) {
  let cookies = document.cookie;
  cookies = cookies.split(";");
  for(let find in cookies) {
    cookieArr = cookies[find].trim().split("=");
    if(cookieArr[0] == cookieName) {
      document.cookie = `${cookieName}=;expires=${new Date().toUTCString()}`;
      console.log(cookieName + " cookie has been deleted");
      return {
        status : true,
        message : "쿠키가 삭제되었습니다."
      };
    }
  }
  console.log(cookieName + " cookie is not exist");
  return {
    status : false,
    message : "쿠키가 존재하지 않습니다"
  };
}

/**
 * 원하는 query의 값을 반환한다
 * @param {string} queryName finding query name
 * @returns 
 */
function getParam(queryName) {
  let url = decodeURI(location.search);
  if(url.includes("?")) {
    let params = decodeURI(url).split("?")[1];
    params = params.split("&");
    for(let param of params) {
      let key = param.split("=")[0];
      let value = param.split("=")[1];
      if(key == queryName) {
        return {
          status : true,
          value : value
        }
      }
    }
    return {
      status : false,
      message : "해당 데이터가 존재하지않음"
    }
  }else {
    return {
      status : false,
      message : "쿼리스트링이 존재하지 않음"
    }
  }
}
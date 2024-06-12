
function addCookie(cookieName, data, expire) {
  document.cookie = `${cookieName}=${data};expires=${expire}`;
  console.log(cookieName + " has been created")
}

// param cookieName : String
// return {
//  status : boolean,
//  message : string
//}
function findCookie(cookieName) {
  let cookies = document.cookie;
  cookies = cookies.split(";");
  for(let find in cookies) {
    cookieArr = cookies[find].trim().split("=");
    if(cookieArr[0] == cookieName) {
      return {
        status : true,
        message : "쿠키가 존재합니다."
      };
    }
  }
  return {
    status : false,
    message : "쿠키가 존재하지 않습니다."
  };
}

// param cookieName : String
// return {
//  status : boolean,
//  message : string
//}
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
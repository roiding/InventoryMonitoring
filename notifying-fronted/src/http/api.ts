import axios from "./http";

export const ADD_NEW_SUBSCRIBE = (
  subscribeType: string,
  address: string,
  platform: string,
  itemId: number | undefined
) =>
  axios.post("/subscribe/addNewNotify", {
      "subscribeType": subscribeType,
      "address": address,
      "platform": platform,
      "itemId": itemId,
  });

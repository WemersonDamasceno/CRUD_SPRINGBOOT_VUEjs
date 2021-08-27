import axios from 'axios'
 
export const http = axios.create({
    //base url da api
    baseURL: 'http://localhost:8080/api/'
})
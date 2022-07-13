import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl="http://localhost:8080/movies"

@Injectable({
  providedIn: 'root'
})
export class MovieService {



  constructor( private httpClient : HttpClient) { }

  readall():Observable<any>{

    console.log("Read All():")
    let movies = this.httpClient.get(`${baseUrl}/`)
    console.log(JSON.stringify(movies));

    return movies;
  
  }

  readSingleMovie(id:any): Observable<any>{

      console.log("single movie");
      let movies=this.httpClient.get(`${baseUrl}/${id}`)
      return movies;
  
  }

  createMovie(data:any):Observable<any>{

    return this.httpClient.post(baseUrl,data);
  }

  deleteMovie(id:any):Observable<any>{

    let movies=this.httpClient.delete(`${baseUrl}/${id}`)
    return movies;
  }
}

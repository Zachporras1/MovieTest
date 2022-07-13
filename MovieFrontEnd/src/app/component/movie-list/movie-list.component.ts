import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/service/movie.service';
import { Movie } from 'src/app/Movie';
import { NgIfContext } from '@angular/common';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

MovieList:Movie[]=[];
currentIndex=-1;
currentProduct=null;
msg:any=""

  constructor(private movieService:MovieService) { }

  ngOnInit(): void {
    this.readMovies();
  }

  readMovies():void{

    this.movieService.readall().subscribe({next:(MovieList)=>
      {this.MovieList=MovieList;console.log(MovieList);
      },

      error:(error)=>{
        console.log(error);
      
      }})
  }

  deleteMovies(id:any):void{
    this.movieService.deleteMovie(id).subscribe({next:(MovieList)=>
      {this.MovieList=MovieList;console.log(MovieList);
      },

      error:(error)=>{
        console.log(error);
      
      }})
      this.refresh();

  }
  refresh(): void {
    window.location.reload();
}

}

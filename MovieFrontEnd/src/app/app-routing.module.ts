import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieCreateComponent } from './component/movie-create/movie-create.component';
import { MovieDetailsComponent } from './component/movie-details/movie-details.component';
import { MovieListComponent } from './component/movie-list/movie-list.component';
import { MovieService } from './service/movie.service';

const routes: Routes = [

  {path: '', redirectTo:'movies',pathMatch:'full'},
  {path:'movies',component:MovieListComponent},
  {path:'movies/:id',component:MovieDetailsComponent},
  {path:'create',component:MovieCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

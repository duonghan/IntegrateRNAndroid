import {connect} from 'react-redux';
import MovieComponent from '../components/MovieComponent';

import {addMovieAction, fetchMoviesAction} from '../actions/index';

const mapStateToProps = (state) => {
    return {
        movies: state.movieReducers
    }
};

const mapDispatchToProps = (dispatch) => {
    debugger;
    return {

        onFetchMovies: () => {
            dispatch(fetchMoviesAction());
        },
        //Not necessary !
        // onSuccessFetch: () => {
        //     dispatch(fetchSuccessAction());
        // },
        onAddMovie: (newMovie) => {
            dispatch(addMovieAction(newMovie));
        }
    };
};

const MovieContainer = connect(mapStateToProps, mapDispatchToProps)(MovieComponent);
export default MovieContainer;
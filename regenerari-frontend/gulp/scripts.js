'use strict';

var path = require('path');
var gulp = require('gulp');
var conf = require('./conf');
var replace = require('gulp-token-replace');
var argv = require('yargs').argv;
var rename = require("gulp-rename");

var browserSync = require('browser-sync');

var $ = require('gulp-load-plugins')();

gulp.task('scripts-replace', function(){

  var constantPath;

  if (argv.dev !== undefined){
    constantPath = path.join(conf.paths.templates, '/app.constants.dev.js');
  }else if (argv.tst !== undefined){
    constantPath = path.join(conf.paths.templates, '/app.constants.tst.js');
  }else if (argv.prd !== undefined){
    constantPath = path.join(conf.paths.templates, '/app.constants.prd.js');
  }else{
    constantPath = path.join(conf.paths.templates, '/app.constants.dev.js');
  }

  return gulp.src([constantPath])
    .pipe(replace({global:conf.environment}))
    .pipe(rename('app.constants.js'))
    .pipe(gulp.dest(path.join(conf.paths.src, '/app')));
});

gulp.task('scripts', ['scripts-replace'], function () {
  return gulp.src(path.join(conf.paths.src, '/app/**/*.js'))
    .pipe($.eslint())
    .pipe($.eslint.format())
    .pipe(browserSync.reload({ stream: true }))
    .pipe($.size())
});

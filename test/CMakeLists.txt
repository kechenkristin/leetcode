cmake_minimum_required(VERSION 3.23)
project(test)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(test
        CountingBits.cpp
        CountingBits.h)

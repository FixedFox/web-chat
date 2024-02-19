package org.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.result.Result;

public interface Command {
    Result execute(HttpServletRequest request, HttpServletResponse response);
}

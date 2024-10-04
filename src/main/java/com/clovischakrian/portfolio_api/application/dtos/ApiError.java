package com.clovischakrian.portfolio_api.application.dtos;

import java.util.List;

public record ApiError(String mensagem, List<String> erros) {
}
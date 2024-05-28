//
//  File.swift
//  domain
//
//  Created by KimMinSeok on 5/28/24.
//

import Foundation

struct GameResult: Hashable{
    let gameCount : Int
    let strike : Int
    let ball : Int
    let number : Int
}

extension GameResult {
    static var list: [GameResult] = [
    ]
}

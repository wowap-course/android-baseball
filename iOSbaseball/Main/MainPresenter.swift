//
//  MainPresenter.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/22/24.
//

import domain

class MainPresenter : MainViewPresenter{
    
    let view : MainView!
    var lifeCount: LifeCount!
    var opponentBall : OpponentBall!
    let referee = Referee()
    
    init(view: MainView, initLifeCount:Int) throws {
        self.view = view
        self.lifeCount = try LifeCount(lifes: initLifeCount)
        self.opponentBall = OpponentBall(numberGenerator: RandomNumberGenerator())
        
        view.showLife(lifeCount: lifeCount.lifes)
    }
    
    func game(userNumber: String) {
        do {
            let userNumbers = try UserBall(numbers: (userNumber.compactMap { Int(String($0)) })).numbers
            
            let resultScore = referee.getGameScore(baseNumbers: userNumbers, targetNumbers: opponentBall.numbers)
            
            if collectNumber(resultScore: resultScore) { view.showSuccess(opponentNumber: Int(opponentBall.numbers.map(String.init).joined())!, lifeCount: lifeCount.lifes) }
            
            resultListUpdate(ball: resultScore.ball, strike: resultScore.strike, number: Int(userNumber)!)
            
            if decreaseLife() { view.showLife(lifeCount: lifeCount.lifes) }
            else { endGame() }
            
        } catch {
            view.showInputError(inputText: userNumber)
        }
    }
    
    func decreaseLife() -> Bool {
        return lifeCount.decrease()
    }
    
    func collectNumber(resultScore : Score) -> Bool {
        return resultScore.strike == 3
    }
    
    func endGame(){
        view.showFail(opponentNumber: Int(opponentBall.numbers.map(String.init).joined())!)
    }
    
    func resultGamePrint(){
        view.showSuccess(opponentNumber: Int(opponentBall.numbers.map(String.init).joined())!, lifeCount: lifeCount.lifes)
    }
    
    func resultListUpdate(ball: Int, strike: Int, number: Int){
        if ball == 0 && strike == 0 {
        }
        
        var output = ""
        if ball > 0 {
            output += "\(ball)볼 "
        }
        if strike > 0 {
            output += "\(strike )스트라이크"
        }
            
        let newGameCount = GameResult.list.count + 1
        let newGameResult = GameResult(gameCount: newGameCount, strike: strike, ball: ball, number: number)
        GameResult.list.insert(newGameResult, at: 0)
        
        view.updateCollectionView()
    }
    
}

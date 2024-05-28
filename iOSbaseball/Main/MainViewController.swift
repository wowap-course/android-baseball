//
//  ViewController.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/18/24.
//

import UIKit
import domain

class MainViewController: UIViewController, MainView {

    @IBOutlet weak var lifeLabel: UILabel!
    @IBOutlet weak var inputBall: UITextField!
    @IBOutlet weak var resultLabel: UILabel!
    @IBOutlet weak var collectionView: UICollectionView!
    
    var lifeCount : Int!
    var presenter : MainPresenter!
    
    let list: [GameResult] = GameResult.list
    typealias Item = GameResult
    
    enum Section {
        case main
    }
    
    var datasource: UICollectionViewDiffableDataSource<Section, Item>!
     
    override func viewDidLoad() {
        super.viewDidLoad()
        initBtn()
        configureCell()
        do {
            self.presenter = try MainPresenter(view: self, initLifeCount: lifeCount)
        } catch {
            print("에러 발생: \(error)")
        }
        
    }
    
    // MARK: - View 로직 부분
    func showLife(lifeCount: Int) {
        lifeLabel.text = "남은 목숨 : \(lifeCount)"
    }
    
    func showInputError(inputText: String) {
        print("올바르지 않은 형식의 입력입니다.")
    }
    
    func updateCollectionView(){
        var snapshot = NSDiffableDataSourceSnapshot<Section, Item>()
        snapshot.appendSections([.main])
        snapshot.appendItems(GameResult.list, toSection: .main)
        datasource.apply(snapshot, animatingDifferences: true)
    }
    
    func showSuccess(opponentNumber: Int, lifeCount: Int) {
        lifeLabel.text = "남은 목숨 : \(lifeCount)"
        makeAlertDialog(title: "성공", message: "정답 \(opponentNumber)")
    }
    
    func showFail(opponentNumber: Int) {
        lifeLabel.text = "남은 목숨 : \(0)"
        makeAlertDialog(title: "실패", message: "정답 \(opponentNumber)")
    }
    

    // MARK: - 버튼 동작 부분
    @IBAction func challengeBtn(_ sender: Any) {
        presenter.game(userNumber: inputBall.text!)
        inputBall.text = ""
    }
    
    // MARK: - UI 코드로 생성 부분
    // 뒤로가기 부분
    private func initBtn(){
        let backButton = UIBarButtonItem(title: "", style: .plain, target: self, action: #selector(backButtonTapped))
        backButton.image = UIImage(systemName: "chevron.left") // iOS 기본 chevron 이미지를 사용
        navigationItem.leftBarButtonItem = backButton
    }
    
    @objc func backButtonTapped() {
        dismiss(animated: true, completion: nil)
        presenter.resultListInit()
    }
    
    // Alert Dialog 생성
    func makeAlertDialog(title: String, message: String, _ isAlert : Bool = true) {

        let alert = isAlert ? UIAlertController(title: title, message: message, preferredStyle: .alert)
        
        : UIAlertController(title: title, message: message, preferredStyle: .actionSheet)
        
        let alertRestartBtn = UIAlertAction(title: "재시작", style: .default) { (action) in
            print("재시작 버튼 클릭")
            self.dismiss(animated: true, completion: nil)
        }
        let alertExitBtn = UIAlertAction(title: "나가기", style: .destructive) { (action) in
            print("나가기 버튼 클릭")
            self.dismiss(animated: true, completion: nil)
        }
        
        if(isAlert) {
            alert.addAction(alertRestartBtn)
            alert.addAction(alertExitBtn)
        }
        else {
            alert.addAction(alertExitBtn)
            alert.addAction(alertRestartBtn)
        }
        
        self.present(alert, animated: true, completion: nil)
    }
    
    // MARK: - Cell 설정 부분
    func configureCell(){
        // Presentation
        datasource = UICollectionViewDiffableDataSource<Section, Item>(collectionView: collectionView, cellProvider: { collectionView, indexPath, itemIdentifier in
            guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "GameResultCollectionViewCell", for: indexPath) as? GameResultCollectionViewCell else {
                return nil
            }
            
            cell.configure(itemIdentifier)
            return cell
        })
        
        // Initial Data
        updateCollectionView()
        
        // Layout
        collectionView.collectionViewLayout = layout()
    }
    
    
    // Layout
    private func layout() -> UICollectionViewCompositionalLayout{
        let itemSize = NSCollectionLayoutSize(widthDimension: .fractionalWidth(1), heightDimension: .fractionalHeight(1))
        let item = NSCollectionLayoutItem(layoutSize: itemSize)
        
        let groupSize = NSCollectionLayoutSize(widthDimension: .fractionalWidth(1), heightDimension: .absolute(150))
        let group = NSCollectionLayoutGroup.horizontal(layoutSize: groupSize, subitem: item, count: 1)
        
        let section = NSCollectionLayoutSection(group: group)
        
        let layout = UICollectionViewCompositionalLayout(section: section)
        return layout
    }

}


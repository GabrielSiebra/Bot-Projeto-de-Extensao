import { useState } from 'react';
import './App.css';
import UniBot from './assets/UniBot.jpeg';

function App() {
  const [isOpen, setIsOpen] = useState(false);
  const [studentId, setStudentId] = useState('');
  const [result, setResult] = useState(null);
  const [hasError, setHasError] = useState(false);
  const [isBotTyping, setIsBotTyping] = useState(false);

  const toggleChat = () => {
    setIsOpen(!isOpen);
    // Limpa a busca ao fechar o chat
    if (isOpen) {
      setResult(null);
      setStudentId('');
      setHasError(false);
    }
  };

  const searchClass = async (e) => {
    e.preventDefault();
    if (!studentId) return;

    setIsBotTyping(true);
    setResult(null);
    setHasError(false);

    try {
      const response = await fetch(`http://localhost:8080/api/bot/consulta/${studentId}`);
      
      if (!response.ok) {
        throw new Error('Server error');
      }

      const data = await response.json();

      setTimeout(() => {
        setResult(data);
        setIsBotTyping(false);
      }, 1000);

    } catch (error) {
      console.error("Error fetching data:", error);
      setTimeout(() => {
        setHasError(true);
        setIsBotTyping(false);
      }, 1000);
    }
  };

  const resetSearch = () => {
    setResult(null);
    setStudentId('');
  };

  return (
    <div className="chatbot-wrapper">
      
      {/* A janela do chat (só renderiza se isOpen for true) */}
      {isOpen && (
        <div className="chatbot-window">
          <div className="chatbot-header">
            <div className="chatbot-header-info">
              <h4>UniBot</h4>
              <p>Consulta de Salas</p>
            </div>
            <button className="chatbot-close-button" onClick={toggleChat}>✕</button>
          </div>

          <div className="chatbot-body">
            {/* Mensagem de boas-vindas */}
            {!result && !hasError && (
              <div className="chat-message bot-message">
                Oi! Sou o UniBot, irei lhe ajudar. Por favor, insira sua matrícula para saber sua sala de aula de hoje.
              </div>
            )}

            {/* Mensagem de Erro */}
            {hasError && (
              <div className="chat-message error-message">
                Desculpe, não consegui conectar ao sistema. Tente novamente mais tarde.
              </div>
            )}

            {/* Resultado da Busca */}
            {result && (
              <div className="chat-message bot-message result-card">
                {result.temAula ? (
                  <>
                    <p>Você tem aula agora!</p>
                    <hr />
                    <p><strong>Disciplina:</strong> {result.disciplina}</p>
                    <p><strong>Sala:</strong> {result.sala}</p>
                    <p><strong>Professor(a):</strong> {result.professor}</p>
                    <p><strong>Horário:</strong> {result.horarioInicio} às {result.horarioFim}</p>
                  </>
                ) : (
                  <p>{result.mensagem}</p>
                )}
                <button className="new-search-button" onClick={resetSearch}>
                  Fazer nova consulta
                </button>
              </div>
            )}
          </div>

          {/* Área de Input*/}
          {!result && (
            <form className="chatbot-footer" onSubmit={searchClass}>
              <input
                type="text"
                className="chatbot-input"
                placeholder="Digite sua matrícula..."
                value={studentId}
                onChange={(e) => setStudentId(e.target.value)}
                autoFocus
              />
              <button type="submit" className="chatbot-send-button">Enviar</button>
            </form>
          )}
        </div>
      )}

      {/*Avatar do Robô) */}
      <button className={`chatbot-toggle-button ${isOpen ? 'active' : ''}`} onClick={toggleChat}>
        {isOpen ? (
          '✕' // Quando o chat estiver aberto, mostra o X
        ) : (
          // Quando o chat estiver minimizado, mostra o avatar do robô
          <img src={UniBot} alt="UniBot" />
        )}
      </button>

    </div>
  );
}

export default App;
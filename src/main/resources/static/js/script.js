console.log("Script.js carregado com sucesso!");

document.addEventListener('DOMContentLoaded', () => {
    console.log("DOM totalmente carregado. Iniciando script.js...");

    // 1. Obtenha referências aos elementos do modal
    const livroModal = document.getElementById('livroModal'); // Este é o ID do seu modal-overlay
    const closeBtn = document.querySelector('.close-btn'); // O span 'x' para fechar
    const modalStarIcon = document.getElementById('modalStarIcon'); // A estrela de favoritar

    const modalLivroImagem = document.getElementById('modalLivroImagem');
    const modalLivroTitulo = document.getElementById('modalLivroTitulo');
    const modalLivroAutor = document.getElementById('modalLivroAutor');
    const modalLivroDescricao = document.getElementById('modalLivroDescricao');

    // ** DEBUG: Verifique se os elementos foram encontrados **
    // Se algum destes for 'null', o JavaScript não conseguirá interagir com o modal.
    // Verifique o console do navegador (F12) por mensagens de erro.
    if (!livroModal) console.error("Erro: 'livroModal' (o overlay principal do modal) não encontrado! Verifique o ID no HTML.");
    if (!closeBtn) console.error("Erro: 'closeBtn' (botão fechar 'x') não encontrado! Verifique a classe no HTML.");
    if (!modalStarIcon) console.error("Erro: 'modalStarIcon' (estrela de favoritar) não encontrado! Verifique o ID no HTML.");
    if (!modalLivroImagem) console.error("Erro: 'modalLivroImagem' não encontrado!");
    if (!modalLivroTitulo) console.error("Erro: 'modalLivroTitulo' não encontrado!");
    if (!modalLivroAutor) console.error("Erro: 'modalLivroAutor' não encontrado!");
    if (!modalLivroDescricao) console.error("Erro: 'modalLivroDescricao' não encontrado!");

    // Se algum elemento essencial não foi encontrado, pare a execução do script.
    if (!livroModal || !closeBtn || !modalStarIcon || !modalLivroImagem || !modalLivroTitulo || !modalLivroAutor || !modalLivroDescricao) {
        console.error("Um ou mais elementos críticos do modal estão faltando. O script foi parado.");
        return;
    }

    // 2. Adicione listeners para fechar o modal
    closeBtn.addEventListener('click', () => {
        console.log("Botão de fechar clicado. Fechando modal.");
        livroModal.style.display = 'none'; // Esconde o overlay do modal
        // Opcional: Remover o estado 'favorited' ao fechar o modal
        modalStarIcon.classList.remove('favorited');
    });

    livroModal.addEventListener('click', (event) => {
        // Se o clique foi no overlay (fundo escurecido), feche o modal
        if (event.target === livroModal) {
            console.log("Fundo do modal clicado. Fechando modal.");
            livroModal.style.display = 'none'; // Esconde o overlay do modal
            // Opcional: Remover o estado 'favorited' ao fechar o modal
            modalStarIcon.classList.remove('favorited');
        }
    });

    // 3. Adicione listeners para abrir o modal quando um card de livro é clicado
    const bookCards = document.querySelectorAll('.livro.clickable-card');
    console.log("Cards encontrados para clique:", bookCards.length);

    bookCards.forEach(card => {
        card.addEventListener('click', () => {
            console.log("Card de livro clicado.");

            // Obtém os dados do livro dos atributos data- do card
            const titulo = card.dataset.titulo;
            const autor = card.dataset.autor;
            const imagem = card.dataset.imagem;
            const descricao = card.dataset.descricao;

            console.log("Dados do livro clicado:", { titulo, autor, imagem, descricao });

            // Preenche os elementos do modal com os dados do livro
            modalLivroImagem.src = imagem;
            modalLivroTitulo.textContent = titulo;
            modalLivroAutor.textContent = autor;
            // Usa a descrição do data-attribute ou um texto padrão se não houver
            modalLivroDescricao.textContent = descricao || 'Nenhuma descrição disponível para este livro.';

            // Exiba o modal definindo o estilo display para 'flex'
            livroModal.style.display = 'flex';
            console.log("Modal exibido.");

            // Reset ou defina o estado da estrela ao abrir o modal para o livro atual
            // Por enquanto, apenas remove a classe 'favorited' para começar "desfavoritado"
            // Se você tiver uma lógica para verificar se o livro atual é favorito, coloque-a aqui
            // Ex: if (isLivroFavorito(titulo)) { modalStarIcon.classList.add('favorited'); }
            modalStarIcon.classList.remove('favorited'); 
        });
    });

    // 4. Adicione listener para o clique na estrela (botão de favoritar)
    modalStarIcon.addEventListener('click', () => {
        console.log("Estrela de favoritar clicada.");
        modalStarIcon.classList.toggle('favorited'); // Adiciona/remove a classe 'favorited'
        
        // Aqui você integraria a lógica para salvar/remover o livro do banco de dados ou localStorage
        // Você precisará do título do livro atual (modalLivroTitulo.textContent) para isso
        const livroAtualTitulo = modalLivroTitulo.textContent; // Pega o título do livro que está no modal
        if (modalStarIcon.classList.contains('favorited')) {
            console.log(`Livro "${livroAtualTitulo}" favoritado!`);
            // Lógica para adicionar aos favoritos (ex: localStorage.setItem(`favorito_${livroAtualTitulo}`, 'true');)
        } else {
            console.log(`Livro "${livroAtualTitulo}" desfavoritado.`);
            // Lógica para remover dos favoritos (ex: localStorage.removeItem(`favorito_${livroAtualTitulo}`);)
        }
    });

    console.log("Script.js inicializado com sucesso.");
});
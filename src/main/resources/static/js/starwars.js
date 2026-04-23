// ── Star Wars Main Theme — Tone.js v14 ───────────────────────────────────────
// FIX: Monaco define window.define (AMD loader). Tone.js lo detecta e intenta
//      registrarse como módulo AMD, lo que falla en el contexto de Monaco.
//      Solución: guardar y neutralizar window.define antes de cargar Tone.js,
//      forzando que se registre como global window.Tone.

(function () {
    var toneLoaded = false;
    var synth      = null;
    var part       = null;
    var playing    = false;
    var transport  = null;
    var BPM        = 104;

    // Tema Principal de Star Wars — John Williams
    var NOTAS = [
        { n: 'Bb3', d: '8n' }, { n: 'Bb3', d: '8n' }, { n: 'Bb3', d: '8n' },
        { n: 'F4',  d: '4n' }, { n: 'C5',  d: '4n' },
        { n: 'Bb4', d: '8n' }, { n: 'A4',  d: '8n' }, { n: 'G4',  d: '8n' },
        { n: 'F5',  d: '4n' }, { n: 'C5',  d: '2n' },
        { n: 'F4',  d: '4n' }, { n: 'C5',  d: '4n' },
        { n: 'Bb4', d: '8n' }, { n: 'A4',  d: '8n' }, { n: 'G4',  d: '8n' },
        { n: 'F5',  d: '4n' }, { n: 'C5',  d: '2n' },
        { n: 'C5',  d: '4n' }, { n: 'G4',  d: '4n' },
        { n: 'Eb4', d: '8n' }, { n: 'D4',  d: '8n' }, { n: 'C4',  d: '8n' },
        { n: 'Bb3', d: '4n' }, { n: 'Bb3', d: '8n' }, { n: 'Bb3', d: '8n' },
        { n: 'F4',  d: '4n' }, { n: 'C5',  d: '4n' },
        { n: 'Bb4', d: '8n' }, { n: 'A4',  d: '8n' }, { n: 'G4',  d: '8n' },
        { n: 'F5',  d: '2n' }
    ];

    function cargarTone(cb) {
        if (toneLoaded) { cb(); return; }

        // FIX: neutralizar AMD define de Monaco para que Tone.js
        //      se registre como global window.Tone
        var savedDefine = window.define;
        window.define   = undefined;

        var s    = document.createElement('script');
        s.src    = 'https://cdn.jsdelivr.net/npm/tone@14.7.77/build/Tone.js';
        s.onload = function () {
            window.define = savedDefine; // restaurar define de Monaco
            toneLoaded    = true;
            cb();
        };
        s.onerror = function () {
            window.define = savedDefine;
            console.error('No se pudo cargar Tone.js');
        };
        document.head.appendChild(s);
    }

    function iniciar() {
        transport = (typeof Tone.getTransport === 'function')
            ? Tone.getTransport()
            : Tone.Transport;

        transport.bpm.value = BPM;

        synth = new Tone.PolySynth(Tone.Synth, {
            oscillator: { type: 'triangle' },
            envelope:   { attack: 0.05, decay: 0.1, sustain: 0.75, release: 0.8 },
            volume:     -6
        }).toDestination();

        var eventos = [];
        var acum    = 0;
        NOTAS.forEach(function (nota) {
            eventos.push({ time: acum, note: nota.n, dur: nota.d });
            acum += Tone.Time(nota.d).toSeconds();
        });

        part          = new Tone.Part(function (time, val) {
            synth.triggerAttackRelease(val.note, val.dur, time);
        }, eventos);
        part.loop     = true;
        part.loopEnd  = acum;
        part.start(0);
        transport.start();
    }

    function detener() {
        if (part)      { part.stop(); part.dispose(); part = null; }
        if (synth)     { synth.dispose(); synth = null; }
        if (transport) { transport.stop(); }
    }

    function toggle(btn) {
        if (!playing) {
            cargarTone(function () {
                Tone.start().then(function () {
                    iniciar();
                    playing = true;
                    btn.classList.add('playing');
                    btn.querySelector('.fuerza-icon').innerHTML = '&#9646;&#9646;';
                }).catch(function (e) {
                    console.error('Tone.start() falló:', e);
                });
            });
        } else {
            detener();
            playing = false;
            btn.classList.remove('playing');
            btn.querySelector('.fuerza-icon').innerHTML = '&#9654;';
        }
    }

    function init() {
        document.querySelectorAll('#btn-fuerza').forEach(function (btn) {
            btn.addEventListener('click', function () { toggle(btn); });
        });
    }

    // Compatible con DOMContentLoaded ya disparado o aún pendiente
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', init);
    } else {
        init();
    }

})();
